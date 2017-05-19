package com.yang.cxft1.cxf.service.impl;

import com.yang.cxft1.cxf.entry.User;
import com.yang.cxft1.cxf.entry.UserInfo;
import com.yang.cxft1.cxf.service.UserInfoService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ASUS on 2017/5/17.
 */
@WebService(targetNamespace = "http://service.cxf.cxft1.yang.com/", portName = "UserInfoServicePort",
        endpointInterface = "com.yang.cxft1.cxf.service.UserInfoService")
@Component
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public User getUser(User perUser) {
        perUser.setName("new");
        return perUser;
    }

    @Override
    public User[] getUsers() {
        User[] users = new User[]{new User(1, "a"), new User(2, "a")};
        return users;
    }

    @Override
    public UserInfo getUserList() {
        UserInfo ui = new UserInfo();
        ArrayList<User> list = new ArrayList<User>();
        list.add(new User(3, "c"));
        list.add(new User(4, "d"));
        ui.setUserList(list);
        return ui;
    }

    @Override
    public UserInfo getUserMap() {
        UserInfo ui = new UserInfo();
        HashMap<String, User> map = new HashMap<String, User>();
        map.put("5", new User(5, "e"));
        map.put("6", new User(6, "f"));
        ui.setUserMap(map);
        return ui;
    }

/*
    // 以下方式会因为对象类型发生异常

    @Override
    public ArrayList<User> getUserList() {
        UserInfo ui = new UserInfo();
        ArrayList<User> list = new ArrayList<User>();
        list.add(new User(3, "c"));
        list.add(new User(4, "d"));
        return list;
    }

    @Override
    public HashMap<String, User> getUserMap() {
        HashMap<String, User> map = new HashMap<String, User>();
        map.put("5", new User(5, "e"));
        map.put("6", new User(6, "f"));
        return map;
    }*/
}
