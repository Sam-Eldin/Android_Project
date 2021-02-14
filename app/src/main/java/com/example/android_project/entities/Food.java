package com.example.android_project.entities;

import android.widget.ImageButton;

public class Food
{
    private Integer mDbid;
    private String mType;
    private Integer mPrice;
    private String mName;
    private ImageButton mImgBtn;
    private String ImagePath;
    //TODO : ADD PHOTO


    public Food(){}
    public Food(Integer aDbid, Integer aPrice, String aName, String aType, ImageButton aImgBtn){

        mDbid = aDbid;
        mPrice = aPrice;
        mName = aName;
        mType = aType;
        mImgBtn = aImgBtn;
    }

    public Integer getDbid()
    {
        return mDbid;
    }

    public void setDbid(Integer mDbid)
    {
        this.mDbid = mDbid;
    }

    public String getName()
    {
        return mName;
    }

    public void setName(String mName)
    {
        this.mName = mName;
    }

    public Integer getPrice()
    {
        return mPrice;
    }

    public void setPrice(Integer mPrice)
    {
        this.mPrice = mPrice;
    }

    public String getType()
    {
        return mType;
    }

    public void setType(String mType)
    {
        this.mType = mType;
    }

    public ImageButton getImgBtn()
    {
        return mImgBtn;
    }

    public void setImgBtn(ImageButton mImgBtn)
    {
        this.mImgBtn = mImgBtn;
    }

    public String getImagePath()
    {
        return ImagePath;
    }

    public void setImagePath(String imagePath)
    {
        ImagePath = imagePath;
    }

    public void updateFrom(Food aFood){
        mDbid = aFood.mDbid;
        mName = aFood.mName;
        mPrice = aFood.mPrice;
        mType = aFood.mType;
        mImgBtn = aFood.mImgBtn;
    }


}

