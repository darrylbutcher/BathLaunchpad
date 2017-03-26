package com.example.darryl.bathlaunchpad;

/**
 * Created by Darryl on 2017-03-26.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MatchesDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Matches.db";
    public static final String TABLE_NAME = "matches_table";
    public static final String ID = "ID";
    public static final String USERID = "USERID";
    public static final String JOBID = "JOBID";

    public MatchesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_JOBS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + USERID + " INT,"
                + JOBID + " INT" + ")";
        db.execSQL(CREATE_JOBS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(int UserID, int JobID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERID, UserID);
        contentValues.put(JOBID, JobID);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getJobs(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select JOBID from " + TABLE_NAME+" where USERID="+ String.valueOf(userid), null);
        return res;
    }

    public Cursor getUsers(int jobid){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select USERID from " + TABLE_NAME+" where JOBID="+ String.valueOf(jobid), null);
        return res;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}