package com.example.android_project.entities;

public class Group {

    private Integer mDbid;
    private String mName;

    public Group(){}


    public Group(Integer aDbid, String aName){
        mDbid = aDbid;
        mName = aName;

    }

    public Integer getmDbid() {
        return mDbid;
    }

    public void setDbid(Integer aDbid) {
        this.mDbid = aDbid;
    }

    public String getName() {
        return mName;
    }

    public void setName(String aName) {
        this.mName = mName;
    }


}
