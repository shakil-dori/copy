package com.example.track;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.lang.reflect.Array;

@Entity
public class Data {
@PrimaryKey
    int id;
@ColumnInfo
    String name="kalachan";
@ColumnInfo
    int value =65;

//constructor

    public Data() {
    }

    public Data(int value) {
        this.value = value;
    }

    public Data(String name) {
        this.name = name;
    }


    //getter setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
