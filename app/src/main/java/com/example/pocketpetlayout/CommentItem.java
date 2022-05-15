package com.example.pocketpetlayout;

public class CommentItem {
    private String writer;
    private String comment;
    private String reg_date;

    public CommentItem(String writer, String comment, String reg_date){

        this.writer = writer;
        this.comment = comment;
        this.reg_date = reg_date;
    }

    public String getWriter() {
        return writer;
    }

    public String getComment() {
        return comment;
    }

    public String getReg_date() {
        return reg_date;
    }
}
