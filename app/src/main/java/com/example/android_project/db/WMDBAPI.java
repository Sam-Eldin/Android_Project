package com.example.android_project.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.BaseColumns;
import android.widget.ImageButton;

import com.example.android_project.arrays.ArrayListFood;
import com.example.android_project.common.Utils;
import com.example.android_project.entities.Food;
import com.example.android_project.entities.Group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_BASE_TYPE_KEY;
import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_FOOD_NAME;
import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_FOOD_PRICE;
import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_FOOD_TYPE;
import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_GROUP_NAME;
import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_IMAGE;
import static com.example.android_project.db.WMSQLiteOpenHelper.TBL_FOOD;
import static com.example.android_project.db.WMSQLiteOpenHelper.TBL_GROUP;

public class WMDBAPI {

    private Context mContext;
    private WMSQLiteOpenHelper mWMSQLiteOpenHelper;
    private SQLiteDatabase mSQLiteDatabaseRW;
    private SQLiteDatabase mSQLiteDatabaseRO;
    private Utils mUtils;

    /**
     * @param aContext
     */
    public WMDBAPI(Context aContext) {
        mContext = aContext;

        mWMSQLiteOpenHelper = new WMSQLiteOpenHelper(mContext);

        mSQLiteDatabaseRO = mWMSQLiteOpenHelper.getReadableDatabase();
        mSQLiteDatabaseRW = mWMSQLiteOpenHelper.getWritableDatabase();

    }

    public boolean saveGroup(Group aGroup){
        ContentValues contentValues = new ContentValues();
        contentValues.put(FLD_GROUP_NAME, aGroup.getName());

        long result = mSQLiteDatabaseRW.insert(TBL_GROUP, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Integer removeGroup(Integer aGroupID){
        int result = mSQLiteDatabaseRW.delete(TBL_GROUP, FLD_BASE_TYPE_KEY + " = " + Arrays.toString(new String[aGroupID]), null);
        return result;
    }

    public boolean saveFood(Food aFood)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FLD_FOOD_NAME, aFood.getName());
        contentValues.put(FLD_FOOD_TYPE, aFood.getType());
        contentValues.put(FLD_FOOD_PRICE, aFood.getPrice());
        byte[] data = mUtils.ImageToByteArray(aFood.getImagePath()); // this is a function
        contentValues.put(FLD_IMAGE, data);

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

    public Integer removeFood(Integer aFoodID) {
        int result = mSQLiteDatabaseRW.delete(TBL_FOOD
                , FLD_BASE_TYPE_KEY + " = " + Arrays.toString(new String[aFoodID]), null);
        return result;
    }

    public ArrayListFood loadFoodList(String aType){
        ArrayListFood arrayListFood= new ArrayListFood();
        String query = "select * from " + TBL_FOOD +
                " WHERE " + FLD_FOOD_TYPE + " = " + aType;

        Cursor res = mSQLiteDatabaseRO.rawQuery(query, new String[]{});
        res.moveToFirst();
        while (!res.isAfterLast()) {

            Bitmap img = Utils.BitmapFromBytes(Utils.ImageToByteArray(res.getString(res.getColumnIndex(FLD_IMAGE))));

            ImageButton imgBtn = new ImageButton(mContext);
            imgBtn.setBackground(new BitmapDrawable(mContext.getResources(), img));

            Food food = new Food(res.getInt(res.getColumnIndex(FLD_BASE_TYPE_KEY)),
                                 res.getInt(res.getColumnIndex(FLD_FOOD_PRICE)),
                                 res.getString(res.getColumnIndex(FLD_FOOD_NAME)),
                                 res.getString(res.getColumnIndex(FLD_FOOD_TYPE)),
                                 imgBtn);
            arrayListFood.add(food);
            res.moveToNext();
        }
        arrayListFood.setLoaded(new Date());
        return arrayListFood;
    }

}
