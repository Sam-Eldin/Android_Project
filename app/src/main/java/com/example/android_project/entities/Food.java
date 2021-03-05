package com.example.android_project.entities;

public class Food {
    private Integer mDbid;
    private String mType;
    private Integer mPrice;
    private String mName;
    private String mImage;


    public Food() {
    }

    public Food(Integer aDbid, Integer aPrice, String aName, String aType, String aImage) {

        mDbid = aDbid;
        mPrice = aPrice;
        mName = aName;
        mType = aType;
        mImage = aImage;
    }

    public Integer getDbid() {
        return mDbid;
    }

    public void setDbid(Integer mDbid) {
        this.mDbid = mDbid;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public Integer getPrice() {
        return mPrice;
    }

    public void setPrice(Integer mPrice) {
        this.mPrice = mPrice;
    }

    public String getType() {
        return mType;
    }

    public void setType(String mType) {
        this.mType = mType;
    }


    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public void updateFrom(Food aFood) {
        mDbid = aFood.mDbid;
        mName = aFood.mName;
        mPrice = aFood.mPrice;
        mType = aFood.mType;
        mImage = aFood.mImage;
    }


}

