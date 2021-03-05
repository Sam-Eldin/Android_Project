package com.example.android_project.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.widget.Toast;

import com.example.android_project.arrays.ArrayListFood;
import com.example.android_project.common.Project;
import com.example.android_project.entities.Food;

import java.util.Date;

import kotlin.contracts.ReturnsNotNull;

import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_FOOD_NAME;
import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_FOOD_PRICE;
import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_FOOD_TYPE;
import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_IMAGE;
import static com.example.android_project.db.WMSQLiteOpenHelper.TBL_FOOD;

public class WMDBAPI {

    private final Context mContext;
    private final SQLiteDatabase mSQLiteDatabaseRW;
    private final SQLiteDatabase mSQLiteDatabaseRO;

    /**
     * @param aContext ddd
     */
    public WMDBAPI(Context aContext) {
        mContext = aContext;

        WMSQLiteOpenHelper mWMSQLiteOpenHelper = new WMSQLiteOpenHelper(mContext);

        mSQLiteDatabaseRO = mWMSQLiteOpenHelper.getReadableDatabase();
        mSQLiteDatabaseRW = mWMSQLiteOpenHelper.getWritableDatabase();

    }

    public void saveFood(Food aFood)
    {
        if(search(aFood.getName()) != null){
            Toast.makeText(Project.APP_INSTANCE.getApplicationContext(), "The food name already exist", Toast.LENGTH_SHORT).show();
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(FLD_FOOD_NAME, aFood.getName());
        contentValues.put(FLD_FOOD_TYPE, aFood.getType());
        contentValues.put(FLD_FOOD_PRICE, aFood.getPrice());

        contentValues.put(FLD_IMAGE, aFood.getImage());

        // TODO : GET IMAGE
       // contentValues.put(FLD_IMAGE, aFood.getImage());


        // if its new save it
        long result;
        if (aFood.getDbid() == null)
        {
            result = mSQLiteDatabaseRW.insert(TBL_FOOD, null, contentValues);
        } else
        {  // if its already exist update it
            result = mSQLiteDatabaseRW.update(TBL_FOOD,
                    contentValues, BaseColumns._ID + "= " + aFood.getDbid(), null);
        }

    }


    private Food search(String name){
        String query = "select * from " + TBL_FOOD + " where " + FLD_FOOD_NAME + "=\"" + name +  "\"";
        Cursor res = mSQLiteDatabaseRO.rawQuery(query, new String[]{});
        if(res.getCount() < 1)
            return null;
        res.moveToFirst();
        Food food = new Food(res.getInt(res.getColumnIndex("_id")),
                res.getInt(res.getColumnIndex(FLD_FOOD_PRICE)),
                res.getString(res.getColumnIndex(FLD_FOOD_NAME)),
                res.getString(res.getColumnIndex(FLD_FOOD_TYPE)),
                res.getString(res.getColumnIndex(FLD_IMAGE)));
        res.close();
        return food;
    }

    public void removeFood(String foodname) {
        Food f = search(foodname);
        if(f == null) {
            Toast.makeText(Project.APP_INSTANCE.getApplicationContext(), "The food name does not exist", Toast.LENGTH_SHORT).show();
            return;
        }
        mSQLiteDatabaseRW.delete(TBL_FOOD
                ,  "_id = " + f.getDbid(), null);
        Toast.makeText(Project.APP_INSTANCE.getApplicationContext(), foodname + " was deleted successfully", Toast.LENGTH_SHORT).show();
    }

    public ArrayListFood loadFoodList(String aType){
        ArrayListFood arrayListFood= new ArrayListFood();
        String query = "select * from " + TBL_FOOD +
                " WHERE " + FLD_FOOD_TYPE + "=\"" + aType+"\"";

        Cursor res = mSQLiteDatabaseRO.rawQuery(query, new String[]{});
        res.moveToFirst();
        while (!res.isAfterLast()) {

            Food food = new Food(res.getInt(res.getColumnIndex("_id")),
                                 res.getInt(res.getColumnIndex(FLD_FOOD_PRICE)),
                                 res.getString(res.getColumnIndex(FLD_FOOD_NAME)),
                                 res.getString(res.getColumnIndex(FLD_FOOD_TYPE)),
                                 res.getString(res.getColumnIndex(FLD_IMAGE)));
            arrayListFood.add(food);
            res.moveToNext();
        }
        arrayListFood.setLoaded(new Date());
        res.close();
        return arrayListFood;
    }

    public int getCount(){
        String query = "select * from " + TBL_FOOD;
        Cursor c = mSQLiteDatabaseRO.rawQuery(query, new String[]{});
        int count = c.getCount();
        c.close();
        return count;
    }
}
