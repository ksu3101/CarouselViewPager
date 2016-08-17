package kr.swkang.carouselviewpager.main;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import kr.swkang.carouselviewpager.main.model.UserCardItem;
import kr.swkang.carouselviewpager.utils.SwObservable;
import kr.swkang.carouselviewpager.utils.mvp.BasePresenter;
import kr.swkang.carouselviewpager.utils.mvp.BaseView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author KangSung-Woo
 * @since 2016/08/16
 */
public class MainActivityPresenter
    extends BasePresenter {
  private static final String TAG = MainActivityPresenter.class.getSimpleName();
  private MainActivity activity;

  public MainActivityPresenter(@NonNull MainActivity activity) {
    this.activity = activity;
  }

  public void retrieveUserList() {
    final SwObservable observable = new SwObservable(
        this,
        Observable.create(
            new Observable.OnSubscribe<ArrayList<UserCardItem>>() {
              @Override
              public void call(Subscriber<? super ArrayList<UserCardItem>> subscriber) {
                ArrayList<UserCardItem> list = new ArrayList<UserCardItem>();

                // make some dummy datas

                subscriber.onNext(list);
              }
            }
        ).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
    );
    observable.subscribe(
        new Subscriber<ArrayList<UserCardItem>>() {
          @Override
          public void onCompleted() {
          }

          @Override
          public void onError(Throwable e) {
            activity.onError(TAG, e.getMessage());
          }

          @Override
          public void onNext(ArrayList<UserCardItem> userCardItems) {
            activity.onRetrieveUserListCompleted(userCardItems);
            onCompleted();
          }
        }
    );
  }

  public interface View
      extends BaseView {
    void onRetrieveUserListCompleted(@NonNull ArrayList<UserCardItem> resultList);
  }

}
