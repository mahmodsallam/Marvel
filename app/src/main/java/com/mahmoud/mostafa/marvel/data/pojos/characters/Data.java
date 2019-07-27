package com.mahmoud.mostafa.marvel.data.pojos.characters;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class Data{
  @SerializedName("total")
  @Expose
  private Integer total;
  @SerializedName("offset")
  @Expose
  private Integer offset;
  @SerializedName("limit")
  @Expose
  private Integer limit;
  @SerializedName("count")
  @Expose
  private Integer count;
  @SerializedName("results")
  @Expose
  private List<Results> results;
  public void setTotal(Integer total){
   this.total=total;
  }
  public Integer getTotal(){
   return total;
  }
  public void setOffset(Integer offset){
   this.offset=offset;
  }
  public Integer getOffset(){
   return offset;
  }
  public void setLimit(Integer limit){
   this.limit=limit;
  }
  public Integer getLimit(){
   return limit;
  }
  public void setCount(Integer count){
   this.count=count;
  }
  public Integer getCount(){
   return count;
  }
  public void setResults(List<Results> results){
   this.results=results;
  }
  public List<Results> getResults(){
   return results;
  }
}