package kr.swkang.carouselviewpager.main.sub;

import android.support.annotation.NonNull;

import kr.swkang.carouselviewpager.utils.mvp.BasePresenter;
import kr.swkang.carouselviewpager.utils.mvp.BaseView;

/**
 * @author KangSung-Woo
 * @since 2016/08/11
 */
public class CardFragPresenter
    extends BasePresenter {
  private CardFragment fragment;

  public CardFragPresenter(@NonNull CardFragment fragment) {
    this.fragment = fragment;

  }

  public interface View
      extends BaseView {
  }

}
