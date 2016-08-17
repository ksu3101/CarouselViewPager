package kr.swkang.carouselviewpager.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import kr.swkang.carouselviewpager.R;
import kr.swkang.carouselviewpager.main.model.UserCardItem;
import kr.swkang.carouselviewpager.main.sub.CardFragment;
import kr.swkang.carouselviewpager.utils.BaseActivity;
import kr.swkang.carouselviewpager.utils.mvp.BasePresenter;

public class MainActivity
    extends BaseActivity
    implements MainActivityPresenter.View {

  private MainActivityPresenter    presenter;
  private ViewPager                viewPager;
  private CarouselViewPagerAdapter adapter;

  @Override
  public BasePresenter attachPresenter() {
    this.presenter = new MainActivityPresenter(this);
    return presenter;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);

    viewPager = (ViewPager) findViewById(R.id.main_ViewPager);

    ArrayList<UserCardItem> list = new ArrayList<>();

    adapter = new CarouselViewPagerAdapter(getSupportFragmentManager(), list);

  }

  @Override
  public void onRetrieveUserListCompleted(@NonNull ArrayList<UserCardItem> resultList) {
    if (adapter != null) {
      adapter.updateDatas(resultList);
    }
  }

  private class CarouselViewPagerAdapter
      extends FragmentStatePagerAdapter {
    private List<UserCardItem> list;

    public CarouselViewPagerAdapter(@NonNull FragmentManager fm, @NonNull List<UserCardItem> list) {
      super(fm);
      this.list = list;
    }

    public void updateDatas(@NonNull List<UserCardItem> list) {
      this.list = list;
      notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
      Bundle args = new Bundle();
      args.putParcelable(CardFragment.BUNDLE_KEY_ITEM, list.get(position));
      return CardFragment.newInstance(args);
    }

    @Override
    public int getCount() {
      if (list != null) return list.size();
      return 0;
    }

    @Override
    public int getItemPosition(Object object) {
      return POSITION_NONE;
    }
  }

}
