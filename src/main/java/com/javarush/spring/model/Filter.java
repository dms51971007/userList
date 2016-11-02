package com.javarush.spring.model;

/**
 * Created by r2 on 01.11.2016.
 */
public class Filter {
    private String nameflt = "";

    public String getNameflt() {
        return nameflt;
    }

    public void setNameflt(String name) {
        this.nameflt = name;
    }

    @Override
    public String toString() {
        if (!nameflt.equals(""))
            return "where name like '" + nameflt + "%'";
        else
            return "";
    }
}
