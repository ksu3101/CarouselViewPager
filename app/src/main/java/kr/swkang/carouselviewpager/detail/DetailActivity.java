package kr.swkang.carouselviewpager.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;

import kr.swkang.carouselviewpager.R;
import kr.swkang.carouselviewpager.utils.BaseActivity;
import kr.swkang.carouselviewpager.utils.mvp.BasePresenter;

/**
 * @author KangSung-Woo
 * @since 2016/08/16
 */
public class DetailActivity
    extends BaseActivity {

  @Override
  public BasePresenter attachPresenter() {
    return null;
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.detail_activity);
  }

}
