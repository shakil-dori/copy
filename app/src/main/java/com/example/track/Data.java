package com.example.track;


public class Data {

    String name = "kalachan";

    int progress ;

    String imgUrl;

//constructor

    public Data() {
    }

    public Data(String name, int progress, String imgUrl) {
        this.name = name;
        this.progress = progress;
        this.imgUrl = imgUrl;
    }
//getter setter


    public String getImgUrl() {
        return imgUrl;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

}
