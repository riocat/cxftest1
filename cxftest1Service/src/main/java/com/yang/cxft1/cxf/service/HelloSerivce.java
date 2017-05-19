package com.yang.cxft1.cxf.service;

import com.yang.cxft1.cxf.entry.User;

import javax.jws.WebService;

/**
 * Created by ASUS on 2017/5/12.
 */
@WebService
public interface HelloSerivce {

    public String sayHello(String name);

    public User feedUser(User comsumer);
}
