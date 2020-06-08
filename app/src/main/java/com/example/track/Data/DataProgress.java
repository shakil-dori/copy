package com.example.track.Data;


public class DataProgress {

    public String name = "kalachan";

    public int progress ;

    public String imgUrl;

//constructor

    public DataProgress() {
    }

    public DataProgress(String name, int progress, String imgUrl) {
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
