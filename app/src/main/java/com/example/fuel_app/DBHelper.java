package com.example.fuel_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
// this class is to handle the sqlite login
public class DBHelper extends SQLiteOpenHelper{

    public String USERTYPE;
    // initializing the DB name is SQLite
    public static final String DBNAME = "UserLogin.db";
    private static final String TAG = "tag";
    // constructor
    public DBHelper(Context context) {
        super(context, "UserLogin.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(vehicle_number TEXT primary key, password TEXT)"); // creating the users table
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop TABLE if exists users");
    }
    // inserting username, password and user type to the local sqlite DB
    public Boolean insertData(String vehicle_number, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("vehicle_number", vehicle_number);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    // check if user already exists
    public Boolean checkusername(String vehicle_number) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where vehicle_number = ?", new String[]{vehicle_number});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    //checking the user inputted UN and PW with DB values
    public Boolean checkusernamepassword(String vehicle_number, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where vehicle_number = ? and password = ?", new String[] {vehicle_number,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
