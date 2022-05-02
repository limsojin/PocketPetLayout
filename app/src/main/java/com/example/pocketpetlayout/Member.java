package com.example.pocketpetlayout;

public class Member {
        public static final String TABLE_NAME = "member";
        public static final String MEMBER_ID = "member_id";
        public static final String PASSWORD = "password";
        public static final String NICKNAME = "nickname";
        public static final String PICTURE = "picture";
        public static final String JOIN_DATE = "join_date";

        private static final String SQL_CREATE_MEMBER =
                "CREATE TABLE " + Member.TABLE_NAME + " (" +
                        Member.MEMBER_ID + " INTEGER PRIMARY KEY, " +
                        Member.PASSWORD + " TEXT, " +
                        Member.NICKNAME + " TEXT, " +
                        Member.PICTURE + " TEXT, " +
                        Member.JOIN_DATE + " TEXT)";

        private static final String SQL_DELETE_MEMBER =
                "DROP TABLE IF EXISTS " + Member.TABLE_NAME;
    }

