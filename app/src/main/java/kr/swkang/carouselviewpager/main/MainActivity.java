package kr.swkang.carouselviewpager.main;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import kr.swkang.carouselviewpager.R;
import kr.swkang.carouselviewpager.main.model.MusicCardItem;

public class MainActivity
    extends AppCompatActivity {

  private ViewPager                viewPager;
  private CarouselViewPagerAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);

    viewPager = (ViewPager) findViewById(R.id.main_ViewPager);

    ArrayList<MusicCardItem> list = new ArrayList<MusicCardItem>();

    adapter = new CarouselViewPagerAdapter(getSupportFragmentManager(), list);

  }

  private class CarouselViewPagerAdapter
      extends FragmentStatePagerAdapter {
    private List<MusicCardItem> list;

    public CarouselViewPagerAdapter(@NonNull FragmentManager fm, @NonNull List<MusicCardItem> list) {
      super(fm);
      this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
      return null;
    }

    @Override
    public int getCount() {
      return 0;
    }
  }

}
