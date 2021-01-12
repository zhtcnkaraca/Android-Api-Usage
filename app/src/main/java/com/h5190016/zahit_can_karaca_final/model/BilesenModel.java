package com.h5190016.zahit_can_karaca_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BilesenModel {

    @SerializedName("Adi")
    @Expose
    private String adi;
    @SerializedName("Hakkinda")
    @Expose
    private String hakkinda;
    @SerializedName("KucukResimURL")
    @Expose
    private String kucukResimURL;
    @SerializedName("BuyukResimURL")
    @Expose
    private String buyukResimURL;
    @SerializedName("Ureticileri")
    @Expose
    private String ureticileri;
    @SerializedName("FiyatAraligi")
    @Expose
    private String fiyatAraligi;

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getHakkinda() {
        return hakkinda;
    }

    public void setHakkinda(String hakkinda) {
        this.hakkinda = hakkinda;
    }

    public String getKucukResimURL() {
        return kucukResimURL;
    }

    public void setKucukResimURL(String kucukResimURL) {
        this.kucukResimURL = kucukResimURL;
    }

    public String getBuyukResimURL() {
        return buyukResimURL;
    }

    public void setBuyukResimURL(String buyukResimURL) {
        this.buyukResimURL = buyukResimURL;
    }

    public String getUreticileri() {
        return ureticileri;
    }

    public void setUreticileri(String ureticileri) {
        this.ureticileri = ureticileri;
    }

    public String getFiyatAraligi() {
        return fiyatAraligi;
    }

    public void setFiyatAraligi(String fiyatAraligi) {
        this.fiyatAraligi = fiyatAraligi;
    }
}
