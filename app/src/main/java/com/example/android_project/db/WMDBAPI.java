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

import java.util.Arrays;
import java.util.Date;

import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_BASE_TYPE_KEY;
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

    public boolean saveFood(Food aFood)
    {
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
        return result != -1;

    }

    public Integer removeFood(Integer aFoodID) {
        return mSQLiteDatabaseRW.delete(TBL_FOOD
                , FLD_BASE_TYPE_KEY + " = " + Arrays.toString(new String[aFoodID]), null);
    }

    public ArrayListFood loadFoodList(String aType){
        ArrayListFood arrayListFood= new ArrayListFood();
        String query = "select * from " + TBL_FOOD +
                " WHERE " + FLD_FOOD_TYPE + "=\"" + aType+"\"";

        Cursor res = mSQLiteDatabaseRO.rawQuery(query, new String[]{});
        res.moveToFirst();
        Toast.makeText(Project.APP_INSTANCE.getApplicationContext(), "Count: " + res.getColumnCount(), Toast.LENGTH_SHORT).show();
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

}
