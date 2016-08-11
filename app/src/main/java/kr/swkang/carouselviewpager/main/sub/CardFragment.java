package kr.swkang.carouselviewpager.main.sub;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kr.swkang.carouselviewpager.R;
import kr.swkang.carouselviewpager.main.model.MusicCardItem;
import kr.swkang.carouselviewpager.utils.BaseFragment;
import kr.swkang.carouselviewpager.utils.mvp.BasePresenter;

/**
 * @author KangSung-Woo
 * @since 2016/08/11
 */
public class CardFragment
    extends BaseFragment
    implements CardFragPresenter.View {
  public static final String TAG             = CardFragment.class.getSimpleName();
  public static final String BUNDLE_KEY_ITEM = TAG + "_BUNDLE_KEY_ITEM";

  private CardFragPresenter presenter;
  private View              rootView;

  @Override
  public BasePresenter attachPresenter() {
    this.presenter = new CardFragPresenter(this);
    return presenter;
  }

  public static CardFragment newInstance(Bundle args) {
    CardFragment fragment = new CardFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.main_f_card, container, false);


    return rootView;
  }

  @Override
  public void retrieveMusicList(boolean isRefresh, List<MusicCardItem> resultList) {
    
  }

  @Override
  public void onLikeJobCompleted(boolean isLiked) {

  }
}
