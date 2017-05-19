package com.yang.cxft1.cxf.service.user;

import com.yang.entry.user.User;
import com.yang.entry.user.UserInfo;

import javax.jws.WebService;
import java.util.List;

@WebService(name = "UserInfoService", targetNamespace = "http://service.cxf.cxft1.yang.com/")
public interface UserInfoService {

    public UserInfo getUserMap();

    public List<User> getUsers();

    public User getUser(User arg0);

    public UserInfo getUserList();

}
