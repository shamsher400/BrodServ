package com.shamsher.brodserv;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by shamsher on 25/6/16.
 */
public class DbHelper extends SQLiteOpenHelper {

    String TAG="Data Base";

    public static final String DATABASE_NAME="AstraApp.db";
    public static final String ASTRA_TABLE_LOCATON="locations";
    public static final String ASTRA_TABLE_CONFIG="config";
    public static final String ASTRA_COLUMN_NAME="name";
    public static final String ASTRA_COLUMN_STREET="street";
    public static final String ASTRA_COLUMN_CITY="city";
    public static final String ASTRA_COLUMN_STATE="state";
    public static final String ASTRA_COLUMN_LATITUDE="latitude";
    public static final String ASTRA_COLUMN_LONGITUDE="longitude";
    public static final String ASTRA_COLUMN_LO_INTERVAL="interval";
    public static final String ASTRA_COLUMN_LO_UPDATE_INTERVAL="update_interval";
    public static final String ASTRA_COLUMN_LO_ACCURACY="accuracy";

    public static final String ASTRA_COLUMN_CO_KEY="key";
    public static final String ASTRA_COLUMN_CO_VAL="value";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

        Log.d(TAG,"created");
    }

    public static final String CREATE_LOCATION_TABLE = "CREATE TABLE "
            + ASTRA_TABLE_LOCATON + "(" + ASTRA_COLUMN_NAME+"TEXT,"
            + ASTRA_COLUMN_STREET + " TEXT, " + ASTRA_COLUMN_CITY + " TEXT, "
            + ASTRA_COLUMN_STATE + " TEXT, " + ASTRA_COLUMN_LATITUDE + " DOUBLE, "
            + ASTRA_COLUMN_LONGITUDE + " DOUBLE, "+ASTRA_COLUMN_LO_INTERVAL+"INT,"
            + ASTRA_COLUMN_LO_UPDATE_INTERVAL + "INT,"+ASTRA_COLUMN_LO_ACCURACY+"INT,";

    public static final String CREATE_CONFIG_TABLE="CREATE TABLE"+ASTRA_TABLE_CONFIG+"("+ASTRA_COLUMN_CO_KEY+"TEXT,"
            +ASTRA_COLUMN_CO_VAL+"TEXT,";
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_LOCATION_TABLE);
        db.execSQL(CREATE_CONFIG_TABLE);
        Log.d(TAG,"Table is created");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query,query1;
        query="DROP TABLE IF EXISITS"+ASTRA_TABLE_CONFIG;
        query1="DROP TABLE IF EXISITS"+ASTRA_TABLE_LOCATON;
        db.execSQL(query);
        db.execSQL(query1);
        onCreate(db);
        Log.d(TAG,"Table already exists");
    }
}
