package kr.swkang.carouselviewpager.utils;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * @author KangSung-Woo
 * @since 2016/08/17
 */
public class ViewPagerTransformer
    implements ViewPager.PageTransformer {
  private static final String TAG = ViewPagerTransformer.class.getSimpleName();

  /**
   * ViewPager Child view의 최소 scale value.
   */
  private static final float MIN_SCALE = 0.72f;     // 0.8f

  /**
   * ViewPager Child view의 최소 alpha value.
   */
  private static final float MIN_ALPHA = 0.3f;      // 0.6f

  /**
   * ViewPager Child view의 최소 translation_y value.
   */
  private static final float MIN_TRANSLATION_Y = 0.08f;

  @Override
  public void transformPage(View page, float position) {
    page.setAlpha(position <= -1f || position >= 1f ? 0f : 1f);
    onTransform(page, position);
  }

  protected void onTransform(View view, float position) {
    int pageWidth = view.getWidth();
    int pageHeight = view.getHeight();

    if (position < -1) { // [-Infinity,-1)
      // This page is way off-screen to the left.
      view.setAlpha(0);
    }

    else if (position <= 1) { // [-1,1]
      // Modify the default slide transition to shrink the page as well
      float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));

      // 중심 좌표의 재 설정
      view.setPivotX(pageWidth / 2);
      view.setPivotY(pageHeight);

      // Scale the page down (between MIN_SCALE and 1)
      view.setScaleX(scaleFactor);
      view.setScaleY(scaleFactor);

      // Fade the page relative to its size.
      view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));

      // set Translation Y
      float translationY = pageHeight * -(1 - Math.abs(position)) * MIN_TRANSLATION_Y;
      view.setTranslationY(translationY);

    }

    else { // (1,+Infinity]
      // This page is way off-screen to the right.
      view.setAlpha(0);
    }
  }// onTransform()

}

