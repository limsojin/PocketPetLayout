package com.example.pocketpetlayout;

public class QnAItem {
    private String mImgName;
    private String mMainText;

    public QnAItem(String mImgName, String mMainText){
        this.mImgName = mImgName;
        this.mMainText = mMainText;
    }

    public String getImgName() {
        return mImgName;
    }

    public void setImgName(String imgName) {
        this.mImgName = imgName;
    }

    public String getMainText() {
        return mMainText;
    }

    public void setMainText(String mainText) {
        this.mMainText = mainText;
    }

}
