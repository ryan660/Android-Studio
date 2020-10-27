package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="register.db";
    public static final String TABLE_NAME ="registeruser";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="username";
    public static final String COL_3 ="password";

    public static final String CART_TABLE ="cartItem";
    public static final String COL_1_2 ="cartItemName";
    public static final String COL_2_2 ="cartItemID";
    public static final String COL_3_2 ="cartItemPrice";
    public static final String COL_4_2 ="cartItemCategory";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE cartItem(ID INTEGER PRIMARY KEY AUTOINCREMENT, cartItemName TEXT, cartItemID TEXT, cartItemPrice TEXT, cartItemCategory TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + CART_TABLE);
        onCreate(sqLiteDatabase);
    }

    public long addUser(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",password);
        long res = db.insert("registeruser", null,contentValues);
        db.close();
        return res;
    }

    public boolean checkUser(String username, String password) {
        String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = { username, password };
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return true;
        else
            return false;
    }
    public Cursor viewCartData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " +CART_TABLE;
        Cursor cursor = db.rawQuery(query,null);
        return cursor;

    }

}

