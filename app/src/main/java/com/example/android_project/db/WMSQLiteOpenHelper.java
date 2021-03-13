package com.example.android_project.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import static android.provider.BaseColumns._ID;

public class WMSQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String TAG = "WMSQLiteOpenHelper";

    public final static int DB_VERSION = 1;
    public final static String DB_NAME = "project.db";

    // tables in DB
    public final static String TBL_FOOD = "food";

    // table food properties
    public final static String FLD_FOOD_NAME = "name";
    public final static String FLD_FOOD_TYPE = "type";
    public final static String FLD_FOOD_PRICE = "price";
    public final static String FLD_IMAGE = "image";

    // general fields
    public static final String FLD_BASE_TYPE_KEY = "integer primary key autoincrement";
    public static final String FLD_TYPE_VARCHAR_1024 = "nvarchar(1024)";
    public static final String FLD_TYPE_VARCHAR_5 = "nvarchar(5)";
    public static final String FLD_TYPE_VARCHAR_30 = "nvarchar(30)";

    public WMSQLiteOpenHelper(Context aContext) {
        this(aContext, DB_NAME, null, DB_VERSION);
    }

    public WMSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    private DatabaseErrorHandler mDatabaseErrorHandler = dbObj -> Log.d(TAG, "db corrupted");

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSQL;

        strSQL = "CREATE TABLE " + TBL_FOOD + " " +
                " (" + _ID + " " + FLD_BASE_TYPE_KEY + " NOT NULL " + "," +
                FLD_FOOD_NAME + " " + FLD_TYPE_VARCHAR_30 + " NOT NULL " + "," +
                FLD_FOOD_TYPE + " " + FLD_TYPE_VARCHAR_30 + " NOT NULL " + "," +
                FLD_FOOD_PRICE + " " + FLD_TYPE_VARCHAR_5 + " NOT NULL " + "," +
                FLD_IMAGE + " " + FLD_TYPE_VARCHAR_1024 + ");";

        Log.d(TAG, strSQL);
        db.execSQL(strSQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if (oldVersion != newVersion)
        {
            db.execSQL("DROP TABLE IF EXISTS " + TBL_FOOD + ";");
            onCreate(db);
        }
    }
}
