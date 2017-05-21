package com.yang.cxft1.cxf.service;

import com.yang.cxft1.cxf.entry.HelloDateTestBean;
import com.yang.cxft1.cxf.entry.User;

import javax.jws.WebService;
import java.util.Date;

/**
 * Created by ASUS on 2017/5/12.
 */
@WebService
public interface HelloSerivce {

    public String sayHello(String name);

    public User feedUser(User comsumer);

    public HelloDateTestBean getHelloDateTestBean();

    public Date getHelloDate();
}
