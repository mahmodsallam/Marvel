package com.mahmoud.mostafa.marvel.data.pojos.characters;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Thumbnail implements Parcelable {
  @SerializedName("path")
  @Expose
  private String path;
  @SerializedName("extension")
  @Expose
  private String extension;

    protected Thumbnail(Parcel in) {
        path = in.readString();
        extension = in.readString();
    }

    public static final Creator<Thumbnail> CREATOR = new Creator<Thumbnail>() {
        @Override
        public Thumbnail createFromParcel(Parcel in) {
            return new Thumbnail(in);
        }

        @Override
        public Thumbnail[] newArray(int size) {
            return new Thumbnail[size];
        }
    };

    public void setPath(String path){
   this.path=path;
  }
  public String getPath(){
   return path;
  }
  public void setExtension(String extension){
   this.extension=extension;
  }
  public String getExtension(){
   return extension;
  }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(path);
        dest.writeString(extension);
    }
}