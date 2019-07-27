package com.mahmoud.mostafa.marvel.data.pojos.characters;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Urls{
  @SerializedName("type")
  @Expose
  private String type;
  @SerializedName("url")
  @Expose
  private String url;
  public void setType(String type){
   this.type=type;
  }
  public String getType(){
   return type;
  }
  public void setUrl(String url){
   this.url=url;
  }
  public String getUrl(){
   return url;
  }
}