package kr.swkang.carouselviewpager.main.model;

import android.os.Parcel;

import kr.swkang.carouselviewpager.utils.mvp.model.BaseCardItem;

/**
 * @author KangSung-Woo
 * @since 2016/08/11
 */
public class UserCardItem
    extends BaseCardItem {
  private String  coverImgUrl;
  private String  coverImgRGB;
  private String  cachedCoverImgPath;
  private String  profileImgUrl;
  private String  userName;
  private String  userTitle;
  private boolean isFollowing;

  public UserCardItem(int id) {
    super(id);
  }

  public String getCoverImgUrl() {
    return coverImgUrl;
  }

  public void setCoverImgUrl(String coverImgUrl) {
    this.coverImgUrl = coverImgUrl;
  }

  public String getCoverImgRGB() {
    return coverImgRGB;
  }

  public void setCoverImgRGB(String coverImgRGB) {
    this.coverImgRGB = coverImgRGB;
  }

  public String getCachedCoverImgPath() {
    return cachedCoverImgPath;
  }

  public void setCachedCoverImgPath(String cachedCoverImgPath) {
    this.cachedCoverImgPath = cachedCoverImgPath;
  }

  public String getProfileImgUrl() {
    return profileImgUrl;
  }

  public void setProfileImgUrl(String profileImgUrl) {
    this.profileImgUrl = profileImgUrl;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserTitle() {
    return userTitle;
  }

  public void setUserTitle(String userTitle) {
    this.userTitle = userTitle;
  }

  public boolean isFollowing() {
    return isFollowing;
  }

  public void setFollowing(boolean following) {
    isFollowing = following;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    super.writeToParcel(dest, flags);
    dest.writeString(this.coverImgUrl);
    dest.writeString(this.coverImgRGB);
    dest.writeString(this.cachedCoverImgPath);
    dest.writeString(this.profileImgUrl);
    dest.writeString(this.userName);
    dest.writeString(this.userTitle);
    dest.writeInt(this.isFollowing ? 1 : 0);
  }

  protected UserCardItem(Parcel in) {
    super(in);
    this.coverImgUrl = in.readString();
    this.coverImgRGB = in.readString();
    this.cachedCoverImgPath = in.readString();
    this.profileImgUrl = in.readString();
    this.userName = in.readString();
    this.userTitle = in.readString();
    this.isFollowing = (in.readInt() == 1);
  }

  public static final Creator<UserCardItem> CREATOR = new Creator<UserCardItem>() {
    @Override
    public UserCardItem createFromParcel(Parcel source) {
      return new UserCardItem(source);
    }

    @Override
    public UserCardItem[] newArray(int size) {
      return new UserCardItem[size];
    }
  };
}
