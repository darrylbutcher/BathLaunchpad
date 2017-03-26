package com.example.darryl.bathlaunchpad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Darryl on 2017-03-26.
 */

public class EmployeeDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Employees.db";
    public static final String TABLE_NAME = "employees_table";
    public static final String ID = "ID";
    public static final String FIRST_NAME = "FIRST_NAME";
    public static final String LAST_NAME = "LAST_NAME";
    public static final String DOB = "DOB";
    public static final String UNI = "UNI";
    public static final String SKILLS = "SKILLS";
    public static final String BIO = "BIO";

    public EmployeeDbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_JOBS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + FIRST_NAME + " TEXT,"
                + LAST_NAME + " TEXT," + DOB + " TEXT," + UNI + " TEXT," + SKILLS + " TEXT," + BIO + " TEXT" + ")";
        db.execSQL(CREATE_JOBS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String firstName, String lastName, String dob, String uni, String skills, String bio){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME, firstName);
        contentValues.put(LAST_NAME, lastName);
        contentValues.put(DOB, dob);
        contentValues.put(UNI, uni);
        contentValues.put(SKILLS, skills);
        contentValues.put(BIO, bio);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }


    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}
