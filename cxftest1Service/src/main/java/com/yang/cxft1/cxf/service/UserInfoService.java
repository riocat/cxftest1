package com.yang.cxft1.cxf.service;

import com.yang.cxft1.cxf.entry.User;
import com.yang.cxft1.cxf.entry.UserInfo;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ASUS on 2017/5/17.
 */
@WebService
public interface UserInfoService {

    public User getUser(User perUser);

    public User[] getUsers();

    public UserInfo getUserList();

    public UserInfo getUserMap();


//    public ArrayList<User> getUserList();
//
//    public HashMap<String, User> getUserMap();
}
