package kr.swkang.carouselviewpager.main;

import android.support.annotation.NonNull;
import android.util.Log;

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
  private MainActivity view;

  public MainActivityPresenter(@NonNull MainActivity activity) {
    this.view = activity;
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
                list.add(new UserCardItem(0, "#1abc9c"));
                list.add(new UserCardItem(1, "#2ecc71"));
                list.add(new UserCardItem(2, "#3498db"));
                list.add(new UserCardItem(3, "#9b59b6"));
                list.add(new UserCardItem(4, "#34495e"));
                list.add(new UserCardItem(5, "#f1c40f"));
                list.add(new UserCardItem(6, "#e67e22"));
                list.add(new UserCardItem(7, "#e74c3c"));

                Log.d(TAG, "// retrieveUserList() data list = " + list.size());
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
            view.onError(TAG, e.getMessage());
          }

          @Override
          public void onNext(ArrayList<UserCardItem> userCardItems) {
            Log.d(TAG, "// retrieveUserList() // onNext() // data list = " + userCardItems.size());
            view.onRetrieveUserListCompleted(userCardItems);
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
