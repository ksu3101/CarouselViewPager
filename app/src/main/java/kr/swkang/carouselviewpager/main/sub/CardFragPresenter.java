package kr.swkang.carouselviewpager.main.sub;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

import java.util.List;

import kr.swkang.carouselviewpager.main.model.UserCardItem;
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

  public void retrieveMusicList(@IntRange(from = 0) int pageOffset) {

  }

  public void toggleLikeMusic(int targetMusicId) {

  }

  public interface View
      extends BaseView {
    void retrieveMusicList(boolean isRefresh, List<UserCardItem> resultList);

    void onLikeJobCompleted(boolean isLiked);
  }

}
