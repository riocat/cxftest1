package com.yang.cxft1.interf.entry;

import java.io.Serializable;

/**
 * Created by ASUS on 2017/5/19.
 */
public class Role implements Serializable{

    private int id;
    private String rname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}
