package com.example.pocketpetlayout;

import android.graphics.Bitmap;

public class NewFeedItem {
    private int id;
    private String title;
    private String writer;
    private String imgName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public NewFeedItem(String title, String writer, String imagName){
        this.title = title;
        this.writer= writer;
        this.imgName = imagName;
    }

}
