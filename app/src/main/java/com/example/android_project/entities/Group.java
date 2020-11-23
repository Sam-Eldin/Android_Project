package com.example.android_project.entities;

public class Group
{
    private Integer mDbid;
    private Integer mNumber;
    private Integer mPrice;
    private String mName;


    public Group(){}
    public Group(Integer aDbid, Integer aNumber, Integer aPrice, String aName){

        mDbid = aDbid;
        mNumber = aNumber;
        mPrice = aPrice;
        mName = aName;
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

    public Integer getNumber()
    {
        return mNumber;
    }

    public void setNumber(Integer mNumber)
    {
        this.mNumber = mNumber;
    }

    public Integer getPrice()
    {
        return mPrice;
    }

    public void setPrice(Integer mPrice)
    {
        this.mPrice = mPrice;
    }


    public void updateFrom(Group aGroup){
        mDbid = aGroup.mDbid;
        mName = aGroup.mName;
        mNumber = aGroup.mNumber;
    }


}

