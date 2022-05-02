package com.example.pocketpetlayout;

import android.database.sqlite.SQLiteOpenHelper;

public class Board {
    public static final String TABLE_NAME = "board";
    public static final String COLUMN_BOARD_ID = "board_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_WRITER = "writer";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_MAINTEXT = "maintext";
    public static final String COLUMN_COMMENT_CNT = "comment_cnt";
    public static final String COLUMN_LIKE_CNT = "like_cnt";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_REGISTER_DATE = "register_date";


    public static final String SQL_CREATE_BOARD =
            "CREATE TABLE " + Board.TABLE_NAME + " (" +
                    Board.COLUMN_BOARD_ID + " INTEGER PRIMARY KEY," +
                    Board.COLUMN_TITLE + " TEXT," +
                    Board.COLUMN_WRITER + " TEXT," +
                    Board.COLUMN_IMAGE + " TEXT," +
                    Board.COLUMN_MAINTEXT + " TEXT," +
                    Board.COLUMN_COMMENT_CNT + " TEXT," +
                    Board.COLUMN_LIKE_CNT + " TEXT," +
                    Board.COLUMN_CATEGORY + " TEXT," +
                    Board.COLUMN_REGISTER_DATE + " TEXT)";

    public static final String SQL_DELETE_BOARD =
            "DROP TABLE IF EXISTS " + Board.TABLE_NAME;
}
