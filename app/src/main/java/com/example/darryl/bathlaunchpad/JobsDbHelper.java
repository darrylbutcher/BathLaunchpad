package com.example.darryl.bathlaunchpad;

/**
 * Created by Darryl on 2017-03-26.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public  class JobsDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Jobs.db";
    public static final String TABLE_NAME = "job_table";
    public static final String ID = "ID";
    public static final String TITLE = "TITLE";
    public static final String ROLE = "ROLE";
    public static final String LOCATION = "LOCATION";
    public static final String DESC = "DESCRIPTION";
    public static final String DATE = "DATE";
    public static final String HOURS = "HOURS";
    public static final String PAY = "PAY";
    public static final String SKILLS = "SKILLS";

    public JobsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_JOBS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TITLE + " TEXT,"
                + ROLE + " TEXT," + LOCATION + " TEXT," + DESC + " TEXT," + DATE + " TEXT," + HOURS + " TEXT," + PAY + " TEXT," + SKILLS + " TEXT" + ")";
        db.execSQL(CREATE_JOBS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean insertData(String title, String role, String location, String description, String date, String hours, String pay, String skills) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TITLE, title);
        contentValues.put(ROLE, role);
        contentValues.put(LOCATION, location);
        contentValues.put(DESC, description);
        contentValues.put(DATE, date);
        contentValues.put(HOURS, hours);
        contentValues.put(PAY, pay);
        contentValues.put(SKILLS, skills);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}