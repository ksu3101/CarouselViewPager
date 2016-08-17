package kr.swkang.carouselviewpager.main.sub;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import kr.swkang.carouselviewpager.R;
import kr.swkang.carouselviewpager.main.model.UserCardItem;
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

    final Bundle args = getArguments();
    if (args != null) {
      final UserCardItem cardItem = args.getParcelable(BUNDLE_KEY_ITEM);
      if (cardItem != null) {

        if (!TextUtils.isEmpty(cardItem.getCoverImgRGB())) {
          Log.d("CardFragment", "// RGB = " + cardItem.getCoverImgRGB());
          LinearLayout containerLayout = (LinearLayout) rootView.findViewById(R.id.main_f_card_container);
          containerLayout.setBackgroundColor(Color.parseColor(cardItem.getCoverImgRGB()));
        }

        TextView tvTitle = (TextView) rootView.findViewById(R.id.main_f_card_tv);
        tvTitle.setText(String.valueOf(cardItem.getId()));

      }
    }
    return rootView;
  }

}
