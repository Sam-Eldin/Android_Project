package com.example.android_project.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.android_project.entities.Food;

import java.util.Arrays;

import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_GROUP_NAME;
import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_GROUP_NUMBER;
import static com.example.android_project.db.WMSQLiteOpenHelper.TBL_GROUP;

public class WMDBAPI
{
    private Context mContext;
    private WMSQLiteOpenHelper mWMSQLiteOpenHelper;
    private SQLiteDatabase mSQLiteDatabaseRW;
    private SQLiteDatabase mSQLiteDatabaseRO;

    /**
     * @param aContext
     */
    public WMDBAPI(Context aContext)
    {
        mContext = aContext;

        mWMSQLiteOpenHelper = new WMSQLiteOpenHelper(mContext);

        mSQLiteDatabaseRO = mWMSQLiteOpenHelper.getReadableDatabase();
        mSQLiteDatabaseRW = mWMSQLiteOpenHelper.getWritableDatabase();
    }

    public boolean saveGroup(Food aFood)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FLD_GROUP_NAME, aFood.getName());
        contentValues.put(FLD_GROUP_NUMBER, aFood.getNumber());
        contentValues.put(FLD_GROUP_NUMBER, aFood.getNumber());


        // if its new save it
        if (aFood.getDbid() == null)
        {

            long result = mSQLiteDatabaseRW.insert(TBL_GROUP, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        } else
        {  // if its already exist update it
            long result = mSQLiteDatabaseRW.update(TBL_GROUP,
                    contentValues, BaseColumns._ID + "= " + aFood.getDbid(), null);
            if (result == -1)
            {
                return false;
            } else
            {
                return true;
            }
        }

    }

    public Integer removeGroup(Integer aGroupID)
    {
        int result = mSQLiteDatabaseRW.delete(TBL_GROUP
                , FLD_GROUP_NUMBER + " = " + Arrays.toString(new String[aGroupID]), null);
        return result;
    }

}

