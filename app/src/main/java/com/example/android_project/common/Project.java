package com.example.android_project.common;

import android.app.Application;

import com.example.android_project.arrays.ArrayListFood;
import com.example.android_project.db.WMDBAPI;

import java.util.ArrayList;

public class Project extends Application
{
    public static Project APP_INSTANCE = null;
    private WMDBAPI mWMDBAPI;


    private ArrayListFood mArrayListFood;

    @Override
    public void onCreate()
    {
        super.onCreate();

        mWMDBAPI = new WMDBAPI(this);

        mArrayListFood = new ArrayListFood();

        APP_INSTANCE = this;
    }

    public WMDBAPI getWMDBAPI() {
        return mWMDBAPI;
    }
    public ArrayListFood getmArrayListFood()
    {
        return mArrayListFood;
    }

    public void setmArrayListFood(ArrayListFood mArrayListFood)
    {
        this.mArrayListFood = mArrayListFood;
    }


}
