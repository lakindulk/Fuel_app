package com.example.fuel_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperOwner extends SQLiteOpenHelper {
    public String USERTYPE;
    // initializing the DB name is SQLite
    public static final String DBNAME = "UserLogin.db";
    private static final String TAG = "tag";
    // constructor
    public DBHelperOwner(Context context) {
        super(context, "OwnerLogin.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table owners(user_name TEXT primary key, password TEXT)"); // creating the users table
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop TABLE if exists owners");
    }
    // inserting username, password and user type to the local sqlite DB
    public Boolean insertData(String user_name, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("user_name", user_name);
        contentValues.put("password", password);
        long result = MyDB.insert("owners", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    // check if user already exists
    public Boolean checkusername(String user_name) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from owners where user_name = ?", new String[]{user_name});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    //checking the user inputted UN and PW with DB values
    public Boolean checkusernamepassword(String user_name, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from owners where user_name = ? and password = ?", new String[] {user_name,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
