package com.example.android_project.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.android_project.entities.Food;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;

public class WMDBAPITest
{

    private Food food;
    private WMDBAPI mDataSource;
    private WMSQLiteOpenHelper mWMSQLiteOpenHelper;
    private SQLiteDatabase mSQLiteDatabaseRO;
    private SQLiteDatabase mSQLiteDatabaseRW;
    private Context mContext;


    @Before
    public void setUp() throws Exception
    {
        food = new Food();
        mContext = InstrumentationRegistry.getInstrumentation().getContext();
        mWMSQLiteOpenHelper = new WMSQLiteOpenHelper(mContext);
        mSQLiteDatabaseRO = mWMSQLiteOpenHelper.getReadableDatabase();
        mSQLiteDatabaseRW = mWMSQLiteOpenHelper.getWritableDatabase();


    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void saveFood()
    {

        food.setName("a");
        food.setPrice(10);
        food.setType("c");
        food.setImage("atHome");
        mDataSource.saveFood(food);
    }

    @Test
    public void removeFood()
    {
    }
}