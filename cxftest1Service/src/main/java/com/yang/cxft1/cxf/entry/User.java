package com.yang.cxft1.cxf.entry;

import java.io.Serializable;

/**
 * Created by ASUS on 2017/5/17.
 */
public class User implements Serializable {

    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
