package com.example.newapp;

public class DrModel {
    int drimg;
    String drname;
    String drexp;

    public DrModel(int drimg, String drname, String drexp) {
        this.drimg = drimg;
        this.drname = drname;
        this.drexp = drexp;
    }

    public int getDrimg() {
        return drimg;
    }

    public void setDrimg(int drimg) {
        this.drimg = drimg;
    }

    public String getDrname() {
        return drname;
    }

    public void setDrname(String drname) {
        this.drname = drname;
    }

    public String getDrexp() {
        return drexp;
    }

    public void setDrexp(String drexp) {
        this.drexp = drexp;
    }
}
