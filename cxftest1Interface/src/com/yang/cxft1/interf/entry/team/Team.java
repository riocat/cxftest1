package com.yang.cxft1.interf.entry.team;

import java.util.Date;

/**
 * Created by ASUS on 2017/5/19.
 */
public class Team {
    private int id;
    private String tname;
    private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
