package com.mahmoud.mostafa.marvel.data.pojos.characters;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Items{
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("resourceURI")
  @Expose
  private String resourceURI;
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setResourceURI(String resourceURI){
   this.resourceURI=resourceURI;
  }
  public String getResourceURI(){
   return resourceURI;
  }
}