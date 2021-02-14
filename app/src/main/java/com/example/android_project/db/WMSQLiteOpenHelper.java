package com.example.android_project.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import androidx.annotation.Nullable;

import static android.provider.BaseColumns._ID;

public class WMSQLiteOpenHelper extends SQLiteOpenHelper
{

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

    // TODO: table group and its properties

    public final static String TBL_GROUP = "groop";
    public final static String FLD_GROUP_NAME = "name";



    // general fields
    public static final String FLD_BASE_TYPE_KEY = "integer primary key autoincrement";
    public static final String FLD_TYPE_INTEGER = "integer";
    public static final String FLD_TYPE_REAL = "real";
    public static final String FLD_TYPE_BLOB = "blob";
    public static final String FLD_TYPE_VARCHAR_2 = "nvarchar(2)";
    public static final String FLD_TYPE_VARCHAR_5 = "nvarchar(5)";
    public static final String FLD_TYPE_VARCHAR_30 = "nvarchar(30)";


    public WMSQLiteOpenHelper(Context aContext) {
        this(aContext, DB_NAME, null, DB_VERSION);

    }

    public WMSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    private DatabaseErrorHandler mDatabaseErrorHandler = new DatabaseErrorHandler() {
        @Override
        public void onCorruption(SQLiteDatabase dbObj) {
            Log.d(TAG, "db corrupted");
        }
    };
//
//    private static final String CREATE_TABLE = "create table " + TBL_GROUP + " (" +
//            _ID
//            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + FLD_GROUP_NAME + " " + FLD_TYPE_VARCHAR_30 + " TEXT NOT NULL, " + " );";

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String strSQL;

        strSQL = "CREATE TABLE " + TBL_FOOD + " " +
                " (" + _ID + " " + FLD_BASE_TYPE_KEY + " NOT NULL " + "," +
                FLD_FOOD_NAME + " " + FLD_TYPE_VARCHAR_30 + " NOT NULL " + "," +
                FLD_FOOD_TYPE + " " + FLD_TYPE_VARCHAR_30 + " NOT NULL " + "," +
                FLD_FOOD_PRICE + " " + FLD_TYPE_VARCHAR_5 + " NOT NULL " + "," +
                FLD_IMAGE + " " + FLD_TYPE_BLOB + ");";

        Log.d(TAG, strSQL);
        db.execSQL(strSQL);

        strSQL = "CREATE TABLE " + TBL_GROUP + " " +
                " (" + _ID + " " + FLD_BASE_TYPE_KEY + " NOT NULL " + "," +
                FLD_GROUP_NAME + " " + FLD_TYPE_VARCHAR_30 + " NOT NULL " + ");";
        Log.d(TAG, strSQL);
        db.execSQL(strSQL);

    //    db.execSQL(CREATE_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if (oldVersion != newVersion)
        {
            db.execSQL(new StringBuilder().append("DROP TABLE IF EXISTS ").append(TBL_FOOD).append(";").toString());
            db.execSQL(new StringBuilder().append("DROP TABLE IF EXISTS ").append(TBL_GROUP).append(";").toString());
            onCreate(db);
        }
    }
}
