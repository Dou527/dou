package com.example.work.model.bean;

public class MeBean {
    private int imgpath;
    private String text;

    public MeBean(int imgpath, String text) {
        this.imgpath = imgpath;
        this.text = text;
    }

    public int getImgpath() {
        return imgpath;
    }

    public void setImgpath(int imgpath) {
        this.imgpath = imgpath;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
