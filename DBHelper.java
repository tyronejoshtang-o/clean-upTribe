package com.example.clean_uptribe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    // Define the database name
    public static final String DBNAME = "Login.db";

    // Constructor for DBHelper class
    public DBHelper(Context context) {

        // Call the superclass constructor to create the database with the given name and version
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        // Create the "users" table with columns: username (primary key) and password
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {

        // Drop the "users" table if it exists (for upgrading the database)
        MyDB.execSQL("drop Table if exists users");

    }

    // Method to insert new user data into the "users" table
    public Boolean insertData(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase(); // Get writable database for inserting data
        ContentValues contentValues = new ContentValues(); // Create a ContentValues object to hold key-value pairs

        // Put the data (username and password) into the contentValues
        contentValues.put("username", username);
        contentValues.put("password", password);

        // Insert the data into the "users" table
        long result = MyDB.insert("user", null, contentValues);

        // If the result is -1, insertion failed; otherwise, return true
        if(result==-1)
            return true;
        return null;
    }

    // Method to check if the username already exists in the database
    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase(); // Get writable database

        // Query the database to check if the username exists
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});

        // If cursor contains any data, the username exists, so return true; otherwise, return false
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    // Method to check if the username and password combination is valid
    public Boolean checkusernamepassword(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase(); // Get writable database

        // Query the database to check if the username and password combination is correct
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username, password});

        // If cursor contains data, the combination is valid, so return true; otherwise, return false
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
