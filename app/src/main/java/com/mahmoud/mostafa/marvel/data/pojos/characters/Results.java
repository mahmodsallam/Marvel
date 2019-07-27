package com.mahmoud.mostafa.marvel.data.pojos.characters;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Awesome Pojo Generator
 */
public class Results implements Parcelable {
    public static final Creator<Results> CREATOR = new Creator<Results>() {
        @Override
        public Results createFromParcel(Parcel in) {
            return new Results(in);
        }

        @Override
        public Results[] newArray(int size) {
            return new Results[size];
        }
    };
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("urls")
    @Expose
    private List<Urls> urls;
    @SerializedName("stories")
    @Expose
    private Stories stories;
    @SerializedName("series")
    @Expose
    private Series series;
    @SerializedName("comics")
    @Expose
    private Comics comics;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("events")
    @Expose
    private Events events;

    @SerializedName("title")
    private String title ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected Results(Parcel in) {
        name = in.readString();
        description = in.readString();
        modified = in.readString();
        thumbnail = in.readParcelable(Thumbnail.class.getClassLoader());
        series = in.readParcelable(Series.class.getClassLoader());
        comics = in.readParcelable(Comics.class.getClassLoader());
        stories=in.readParcelable(Stories.class.getClassLoader()) ;
        events = in.readParcelable(Events.class.getClassLoader()) ;

        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        resourceURI = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(modified);
        dest.writeParcelable(thumbnail, 1);
        dest.writeParcelable(series, 2);
        dest.writeParcelable(comics, 3);
        dest.writeParcelable(stories , 4 );
        dest.writeParcelable(events , 5 );

        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(resourceURI);
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<Urls> getUrls() {
        return urls;
    }

    public void setUrls(List<Urls> urls) {
        this.urls = urls;
    }

    public Stories getStories() {
        return stories;
    }

    public void setStories(Stories stories) {
        this.stories = stories;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Comics getComics() {
        return comics;
    }

    public void setComics(Comics comics) {
        this.comics = comics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    @Override
    public int describeContents() {
        return 0;
    }


}