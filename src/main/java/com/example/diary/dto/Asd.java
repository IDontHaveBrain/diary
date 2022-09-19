package com.example.diary.dto;

import javax.persistence.Entity;

public class Asd {
    private int idasd;
    private String asdcol;

    public Asd() {
    }

    public Asd(int idasd, String asdcol) {
        this.idasd = idasd;
        this.asdcol = asdcol;
    }

    public int getIdasd() {
        return idasd;
    }

    public void setIdasd(int idasd) {
        this.idasd = idasd;
    }

    public String getAsdcol() {
        return asdcol;
    }

    public void setAsdcol(String asdcol) {
        this.asdcol = asdcol;
    }
}
