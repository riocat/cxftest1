package com.yang.entry.user;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userInfo", propOrder = {
    "user",
    "userList",
    "userMap",
    "users"
})
public class UserInfo {

    protected User user;
    @XmlElement(nillable = true)
    protected List<User> userList;
    @XmlElement(required = true)
    protected UserInfo.UserMap userMap;
    @XmlElement(nillable = true)
    protected List<User> users;

    public User getUser() {
        return user;
    }

    public void setUser(User value) {
        this.user = value;
    }

    public List<User> getUserList() {
        if (userList == null) {
            userList = new ArrayList<User>();
        }
        return this.userList;
    }

    public UserInfo.UserMap getUserMap() {
        return userMap;
    }

    public void setUserMap(UserInfo.UserMap value) {
        this.userMap = value;
    }

    public List<User> getUsers() {
        if (users == null) {
            users = new ArrayList<User>();
        }
        return this.users;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entry"
    })
    public static class UserMap {

        protected List<UserInfo.UserMap.Entry> entry;

        public List<UserInfo.UserMap.Entry> getEntry() {
            if (entry == null) {
                entry = new ArrayList<UserInfo.UserMap.Entry>();
            }
            return this.entry;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "key",
            "value"
        })
        public static class Entry {

            protected String key;
            protected User value;

            public String getKey() {
                return key;
            }

            public void setKey(String value) {
                this.key = value;
            }

            public User getValue() {
                return value;
            }

            public void setValue(User value) {
                this.value = value;
            }

        }

    }

}
