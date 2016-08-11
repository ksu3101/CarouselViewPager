package kr.swkang.carouselviewpager.utils.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author KangSung-Woo
 * @since 2016/08/11
 */
public class BaseCardItem
    implements Parcelable {
  private int    id;
  private String tag;

  public BaseCardItem() {
    init();
  }

  public BaseCardItem(int id) {
    init();
    this.id = id;
  }

  private void init() {
    this.id = -1;
    this.tag = null;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.tag);
  }

  protected BaseCardItem(Parcel in) {
    this.id = in.readInt();
    this.tag = in.readString();
  }

  public static final Parcelable.Creator<BaseCardItem> CREATOR = new Parcelable.Creator<BaseCardItem>() {
    @Override
    public BaseCardItem createFromParcel(Parcel source) {
      return new BaseCardItem(source);
    }

    @Override
    public BaseCardItem[] newArray(int size) {
      return new BaseCardItem[size];
    }
  };
}
