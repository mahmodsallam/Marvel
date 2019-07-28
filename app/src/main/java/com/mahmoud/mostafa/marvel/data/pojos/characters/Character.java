package com.mahmoud.mostafa.marvel.data.pojos.characters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Character {
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("attributionHTML")
    @Expose
    private String attributionHTML;
    @SerializedName("attributionText")
    @Expose
    private String attributionText;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("status")
    @Expose
    private String status;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}