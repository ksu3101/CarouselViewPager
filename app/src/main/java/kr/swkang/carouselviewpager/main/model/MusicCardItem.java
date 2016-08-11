package kr.swkang.carouselviewpager.main.model;

import android.os.Parcel;

import kr.swkang.carouselviewpager.utils.mvp.model.BaseCardItem;

/**
 * @author KangSung-Woo
 * @since 2016/08/11
 */
public class MusicCardItem
    extends BaseCardItem {
  private String thumbNailImgUrl;
  private String imgRGB;
  private String title;
  private String category;
  private String desc;
  private int    likeCount;
  private int    replyCount;

  public MusicCardItem(int id) {
    super(id);
  }

  public String getThumbNailImgUrl() {
    return thumbNailImgUrl;
  }

  public void setThumbNailImgUrl(String thumbNailImgUrl) {
    this.thumbNailImgUrl = thumbNailImgUrl;
  }

  public String getImgRGB() {
    return imgRGB;
  }

  public void setImgRGB(String imgRGB) {
    this.imgRGB = imgRGB;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public int getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(int likeCount) {
    this.likeCount = likeCount;
  }

  public int getReplyCount() {
    return replyCount;
  }

  public void setReplyCount(int replyCount) {
    this.replyCount = replyCount;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    super.writeToParcel(dest, flags);
    dest.writeString(this.thumbNailImgUrl);
    dest.writeString(this.imgRGB);
    dest.writeString(this.title);
    dest.writeString(this.category);
    dest.writeString(this.desc);
    dest.writeInt(this.likeCount);
    dest.writeInt(this.replyCount);
  }

  protected MusicCardItem(Parcel in) {
    super(in);
    this.thumbNailImgUrl = in.readString();
    this.imgRGB = in.readString();
    this.title = in.readString();
    this.category = in.readString();
    this.desc = in.readString();
    this.likeCount = in.readInt();
    this.replyCount = in.readInt();
  }

  public static final Creator<MusicCardItem> CREATOR = new Creator<MusicCardItem>() {
    @Override
    public MusicCardItem createFromParcel(Parcel source) {
      return new MusicCardItem(source);
    }

    @Override
    public MusicCardItem[] newArray(int size) {
      return new MusicCardItem[size];
    }
  };
}
