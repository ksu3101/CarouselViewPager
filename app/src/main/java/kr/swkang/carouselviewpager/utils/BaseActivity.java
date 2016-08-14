package kr.swkang.carouselviewpager.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

import kr.swkang.carouselviewpager.utils.mvp.BasePresenter;
import kr.swkang.carouselviewpager.utils.mvp.BaseView;

/**
 * @author KangSung-Woo
 * @since 2016/07/20
 */
public abstract class BaseActivity
    extends AppCompatActivity
    implements BaseView {
  protected static final int MIN_KEYBOARD_HEIGHT = 150;

  private BasePresenter                           basePresenter;
  private View                                    decorView;
  private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;

  // - - Abstract methods - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  public abstract BasePresenter attachPresenter();

  // - - Callback Methods - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  public void onKeyboardShown(int keyboardHeight) {
  }

  public void onKeyboardHidden() {
  }

  // - - Life cycle methods  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.basePresenter = attachPresenter();
  }

  @Override
  protected void onDestroy() {
    if (basePresenter != null) {
      // unscribe registered Subscriptions
      basePresenter.destroy();
    }
    if (decorView != null && globalLayoutListener != null) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        decorView.getViewTreeObserver().removeOnGlobalLayoutListener(globalLayoutListener);
      }
      else {
        decorView.getViewTreeObserver().removeGlobalOnLayoutListener(globalLayoutListener);
      }
    }
    super.onDestroy();
  }

  // - - Implements methods - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @CallSuper
  @Override
  public void onError(String tag, String message) {
    Log.e(tag != null ? tag : "BaseActivity", message != null ? message : "Message is null.");
  }

  // - - Common methods - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  public void checkSoftKeyboardOnActivity() {
    decorView = getWindow().getDecorView();
    globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
      private final Rect windowVisibleDisplayFrame = new Rect();
      private int lastVisibleDecorViewHeight;

      @Override
      public void onGlobalLayout() {
        // 보여지고 있는 window의 크기를 사각형 Rect객체로 가져 온다.
        decorView.getWindowVisibleDisplayFrame(windowVisibleDisplayFrame);
        final int visibleDecorViewHeight = windowVisibleDisplayFrame.height();

        // 보여지고 있는 높이의 계산 결과에 따라 키보드의 등장 유무를 확인 한다.
        if (lastVisibleDecorViewHeight != 0) {
          if (lastVisibleDecorViewHeight > visibleDecorViewHeight + MIN_KEYBOARD_HEIGHT) {
            final int currentKeyboardHeight = decorView.getHeight() - windowVisibleDisplayFrame.bottom;
            // 키보드가 등장중인 상태
            onKeyboardShown(currentKeyboardHeight);
          }
          else if (lastVisibleDecorViewHeight + MIN_KEYBOARD_HEIGHT < visibleDecorViewHeight) {
            // 키보드가 사라진 상태
            onKeyboardHidden();
          }
        }
        lastVisibleDecorViewHeight = visibleDecorViewHeight;
      }
    };
  }

}
