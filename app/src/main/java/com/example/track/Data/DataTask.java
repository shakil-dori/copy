package com.example.track.Data;

import java.util.Date;

public class DataTask {
String task;
Date date;
boolean isdone;
Date alarm;
// constructor
    public DataTask() {
    }

    public DataTask(String task, Date date, boolean isdone, Date alarm) {
        this.task = task;
        this.date = date;
        this.isdone = isdone;
        this.alarm = alarm;
    }
// getter
    public String getTask() {
        return task;
    }

    public Date getDate() {
        return date;
    }

    public boolean isIsdone() {
        return isdone;
    }

    public Date getAlarm() {
        return alarm;
    }
}
