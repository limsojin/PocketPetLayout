package com.example.pocketpetlayout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Pocketpet.db";

    private static final String SQL_CREATE_MEMBER =
            "CREATE TABLE " + Member.TABLE_NAME + " (" +
                    Member.MEMBER_ID + " INTEGER PRIMARY KEY, " +
                    Member.PASSWORD + " TEXT, " +
                    Member.NICKNAME + " TEXT, " +
                    Member.PICTURE + " TEXT, " +
                    Member.JOIN_DATE + " TEXT)";

    private static final  String SQL_DELETE_MEMBER =
            "DROP TABLE IF EXISTS " + Member.TABLE_NAME;

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_MEMBER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_MEMBER);
        onCreate(sqLiteDatabase);
    }
}

