package com.example.pocketpetlayout;

public class BoardItem {
    private int id;
    private String title;
    private String writer;
    private String reg_date;
    private int heart;
    private int comment;

    public BoardItem(int id, String title, String writer, String reg_date, int heart, int comment){
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.reg_date = reg_date;
        this.heart = heart;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getReg_date() {
        return reg_date;
    }

    public int getHeart() {
        return heart;
    }

    public int getComment() {
        return comment;
    }
}
