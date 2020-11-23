package com.example.android_project.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import androidx.annotation.Nullable;

public class WMSQLiteOpenHelper extends SQLiteOpenHelper
{

    public static final String TAG = "WMSQLiteOpenHelper";

    public final static int DB_VERSION = 1;
    public final static String DB_NAME = "project.db";

    // tables in DB
    public final static String TBL_GROUP = "group";

    // table group properties
    public final static String FLD_GROUP_NAME = "name";
    public final static String FLD_GROUP_NUMBER = "number";
    public final static String FLD_GROUP_PRICE = "price";
    public final static String FLD_IMAGE = "image";

    // TODO: table items and its properties




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


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String strSQL;

        strSQL = new StringBuilder().append("CREATE TABLE ").append(TBL_GROUP).append(" ")
                .append(" (").append(BaseColumns._ID).append(" ").append(FLD_BASE_TYPE_KEY).append(" NOT NULL ").append(",")
                .append(FLD_GROUP_NAME).append(" ").append(FLD_TYPE_VARCHAR_30).append(" NOT NULL ").append(",")
                .append(FLD_GROUP_NUMBER).append(" ").append(FLD_TYPE_VARCHAR_2).append(" NOT NULL ").append(",")
                .append(FLD_GROUP_PRICE).append(" ").append(FLD_TYPE_VARCHAR_5).append(" NOT NULL ").append(",")
                .append(FLD_IMAGE).append(" ").append(FLD_TYPE_BLOB).append(");")
                .toString();

        Log.d(TAG, strSQL);
        db.execSQL(strSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if (oldVersion != newVersion)
        {
            db.execSQL(new StringBuilder().append("DROP TABLE IF EXISTS ").append(TBL_GROUP).append(";").toString());

            onCreate(db);
        }
    }
}
