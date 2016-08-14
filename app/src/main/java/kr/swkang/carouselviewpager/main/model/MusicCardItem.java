package kr.swkang.carouselviewpager.main.model;

import android.os.Parcel;

import kr.swkang.carouselviewpager.utils.mvp.model.BaseCardItem;

/**
 * @author KangSung-Woo
 * @since 2016/08/11
 */
public class MusicCardItem
    extends BaseCardItem {
  private String  artistImgUrl;
  private String  coverImgUrl;
  private String  coverImgRGB;
  private String  cachedCoverImgPath;
  private String  title;
  private String  category;
  private String  artist;
  private String  albumName;
  private boolean isLike;

  public MusicCardItem(int id) {
    super(id);
  }

  public String getArtistImgUrl() {
    return artistImgUrl;
  }

  public void setArtistImgUrl(String artistImgUrl) {
    this.artistImgUrl = artistImgUrl;
  }

  public void setCachedCoverImgPath(String cachedCoverImgPath) {
    this.cachedCoverImgPath = cachedCoverImgPath;
  }

  public String getCachedCoverImgPath() {
    return cachedCoverImgPath;
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

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public String getAlbumName() {
    return albumName;
  }

  public void setAlbumName(String albumName) {
    this.albumName = albumName;
  }

  public boolean isLike() {
    return isLike;
  }

  public void setLike(boolean like) {
    isLike = like;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    super.writeToParcel(dest, flags);
    dest.writeString(this.cachedCoverImgPath);
    dest.writeString(this.artistImgUrl);
    dest.writeString(this.coverImgUrl);
    dest.writeString(this.coverImgRGB);
    dest.writeString(this.title);
    dest.writeString(this.category);
    dest.writeString(this.artist);
    dest.writeString(this.albumName);
    dest.writeInt(this.isLike ? 1 : 0);
  }

  protected MusicCardItem(Parcel in) {
    super(in);
    this.cachedCoverImgPath = in.readString();
    this.artistImgUrl = in.readString();
    this.coverImgUrl = in.readString();
    this.coverImgRGB = in.readString();
    this.title = in.readString();
    this.category = in.readString();
    this.artist = in.readString();
    this.albumName = in.readString();
    this.isLike = (in.readInt() == 1);
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
