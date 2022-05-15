package com.example.pocketpetlayout;

public class Comment {
    public static final String TABLE_NAME = "comment";
    public static final String COLUMN_BOARD_ID = "board_id";
    public static final String COLUMN_NICKNAME = "nickname";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_CREATE_DATE = "create_date";

    public static final String SQL_CREATE_COMMENT =
            "CREATE TABLE " + Comment.TABLE_NAME + " (" +
                    Comment.COLUMN_BOARD_ID + " INTEGER, " +
                    Comment.COLUMN_NICKNAME + " TEXT," +
                    Comment.COLUMN_CONTENT + " TEXT," +
                    Comment.COLUMN_CREATE_DATE + " TEXT)" ;

    public static final String SQL_DELETE_COMMENT =
            "DROP TABLE IF EXISTS " + Comment.TABLE_NAME;
}
