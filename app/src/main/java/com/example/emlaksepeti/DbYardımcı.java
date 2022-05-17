package com.example.emlaksepeti;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbYardımcı extends SQLiteOpenHelper {



    public static final String DBname= "Login.db";

    public DbYardımcı(Context context) {
        super(context, "Login.db",null, 1);
    }



    public void onCreate(SQLiteDatabase MyDb) {
    MyDb.execSQL("create Table users(username TEXT primary key,password TEXT,mail TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDb, int i, int i1) {
    MyDb.execSQL("drop Table if exists users");
    }
    public Boolean insertData(String username,String password){
        SQLiteDatabase MyDB =   this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = MyDB.insert("users",null, contentValues);
        if (result==-1) return false;
        else
            return true;
    }
    public boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor  cursor  =   MyDB.rawQuery("Select * from users where username=?",new String[]{username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor   =   MyDB.rawQuery("Select * from users where username = ? and password = ?"
                ,new String[]{username,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }



}
