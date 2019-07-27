package com.mahmoud.mostafa.marvel.data.pojos.characters;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class Stories implements Parcelable {
  @SerializedName("collectionURI")
  @Expose
  private String collectionURI;
  @SerializedName("available")
  @Expose
  private Integer available;
  @SerializedName("returned")
  @Expose
  private Integer returned;
  @SerializedName("items")
  @Expose
  private List<Items> items;

    protected Stories(Parcel in) {
        collectionURI = in.readString();
        if (in.readByte() == 0) {
            available = null;
        } else {
            available = in.readInt();
        }
        if (in.readByte() == 0) {
            returned = null;
        } else {
            returned = in.readInt();
        }
    }

    public static final Creator<Stories> CREATOR = new Creator<Stories>() {
        @Override
        public Stories createFromParcel(Parcel in) {
            return new Stories(in);
        }

        @Override
        public Stories[] newArray(int size) {
            return new Stories[size];
        }
    };

    public void setCollectionURI(String collectionURI){
   this.collectionURI=collectionURI;
  }
  public String getCollectionURI(){
   return collectionURI;
  }
  public void setAvailable(Integer available){
   this.available=available;
  }
  public Integer getAvailable(){
   return available;
  }
  public void setReturned(Integer returned){
   this.returned=returned;
  }
  public Integer getReturned(){
   return returned;
  }
  public void setItems(List<Items> items){
   this.items=items;
  }
  public List<Items> getItems(){
   return items;
  }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(collectionURI);
        if (available == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(available);
        }
        if (returned == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(returned);
        }
    }
}