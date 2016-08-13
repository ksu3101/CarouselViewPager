package kr.swkang.carouselviewpager.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.text.TextUtils;

/**
 * @author KangSung-Woo
 * @since 2016/08/11
 */
public class Utils {

  /**
   * Drawable1과 Drawable2간의 트랜지션 에니메이션을 적용한 TransitionDrawable을 만든다.
   * 만들어진 TransitionDrawable의 객채의 startTransition(durationMillis)메소드를 이용하여
   * 애니메이션을 시작 한다.
   *
   * @param layer1 before Drawable.
   * @param layer2 after Drawable.
   * @return {@link TransitionDrawable}
   */
  public static TransitionDrawable createTransitionDrawable(Drawable layer1, Drawable layer2) {
    TransitionDrawable td = new TransitionDrawable(new Drawable[]{layer1, layer2});
    td.setCrossFadeEnabled(true);
    return td;
  }

  /**
   * Drawable1(resId1) 과 Drawable2(resId2)간의 트랜지션 애니메이션을 적용한 TransitionDrwable을 만든다.  만들어진
   * TransitionDrwable 객체의 startTransition(durationMillis)를 이용하여 애니메이션을 시작한다.
   *
   * @param res         Resources (from Context)
   * @param layerResId1 before Drawable Resource ID.
   * @param layerResId2 after Drawable Resource ID.
   * @return {@link TransitionDrawable}
   */
  public static TransitionDrawable createTransitionDrawable(Resources res,
                                                            int layerResId1,
                                                            int layerResId2) {
    if (res != null) {
      TransitionDrawable td = new TransitionDrawable(new Drawable[]{res.getDrawable(layerResId1),
          res.getDrawable(layerResId2)});
      td.setCrossFadeEnabled(true);
      return td;
    }
    return null;
  }

  /**
   * Bitmap이미지를 리사이즈 한다.
   *
   * @param originalImg   리사이즈 대상 원본 Bitmap 이미지.
   * @param maxResolution width, height 대상 중 최대 감안 크기.
   * @return 리사이징 된 Bitmap 이미지.
   */
  public static Bitmap getResizeImg(Bitmap originalImg, int maxResolution) {
    if (originalImg == null) return null;
    final int width = originalImg.getWidth();
    final int height = originalImg.getHeight();
    int newWidth = width;
    int newHeight = height;
    float rate = 0.0f;

    if (width > height) {
      if (maxResolution < width) {
        rate = maxResolution / (float) width;
        newHeight = (int) (height * rate);
        newWidth = maxResolution;
      }
    }
    else {
      if (maxResolution < height) {
        rate = maxResolution / (float) height;
        newWidth = (int) (width * rate);
        newHeight = maxResolution;
      }
    }
    return Bitmap.createScaledBitmap(originalImg, newWidth, newHeight, true);
  }

  /**
   * 문자열 str이 이미지 경로 인지 여부를 확인 한다.
   *
   * @param str 이미지 경로인지 체크할 문자열
   * @return true일 경우 이미지 경로
   */
  public static boolean isImagePath(String str) {
    if (!TextUtils.isEmpty(str)) {
      return (str.endsWith(".png") || str.endsWith(".jpg") || str.endsWith(".jpeg") || str.endsWith(".webp") || str.endsWith(".gif"));
    }
    return false;
  }
}
