package com.example.android_project.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.android_project.entities.Food;

import java.util.Arrays;

import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_BASE_TYPE_KEY;
import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_FOOD_NAME;
import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_FOOD_PRICE;
import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_IMAGE;
import static com.example.android_project.db.WMSQLiteOpenHelper.TBL_FOOD;

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

    public boolean saveFood(Food aFood)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FLD_FOOD_NAME, aFood.getName());
        contentValues.put(FLD_FOOD_PRICE, aFood.getPrice());

        // TODO : GET IMAGE
       // contentValues.put(FLD_IMAGE, aFood.getImage());


        // if its new save it
        if (aFood.getDbid() == null)
        {

            long result = mSQLiteDatabaseRW.insert(TBL_FOOD, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        } else
        {  // if its already exist update it
            long result = mSQLiteDatabaseRW.update(TBL_FOOD,
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

    public Integer removeFood(Integer aFoodID)
    {
        int result = mSQLiteDatabaseRW.delete(TBL_FOOD
                , FLD_BASE_TYPE_KEY + " = " + Arrays.toString(new String[aFoodID]), null);
        return result;
    }

}

