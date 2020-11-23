package com.example.android_project.common;

import android.app.Application;

import com.example.android_project.db.WMDBAPI;

public class Project extends Application
{
    public static Project APP_INSTANCE = null;
    private WMDBAPI mWMDBAPI;


    @Override
    public void onCreate()
    {
        super.onCreate();
        mWMDBAPI = new WMDBAPI(this);


        APP_INSTANCE = this;
    }
}
