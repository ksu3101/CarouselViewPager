package kr.swkang.carouselviewpager.main.sub;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.swkang.carouselviewpager.R;
import kr.swkang.carouselviewpager.utils.BaseFragment;
import kr.swkang.carouselviewpager.utils.mvp.BasePresenter;

/**
 * @author KangSung-Woo
 * @since 2016/08/11
 */
public class CardFragment
    extends BaseFragment {
  private CardFragPresenter presenter;
  private View              rootView;

  @Override
  public BasePresenter attachPresenter() {
    this.presenter = new CardFragPresenter(this);
    return presenter;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.main_f_card, container, false);


    return rootView;
  }
}
