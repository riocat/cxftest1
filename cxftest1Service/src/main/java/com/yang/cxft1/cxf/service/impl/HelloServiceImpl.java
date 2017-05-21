package com.yang.cxft1.cxf.service.impl;

import com.yang.cxft1.cxf.entry.HelloDateTestBean;
import com.yang.cxft1.cxf.entry.User;
import com.yang.cxft1.cxf.service.HelloSerivce;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.Date;

/**
 * Created by ASUS on 2017/5/12.
 */
//@WebService(endpointInterface = "com.yang.cxft1.cxf.service.HelloSerivce")
@WebService(targetNamespace = "http://service.cxf.cxft1.yang.com/", endpointInterface = "com.yang.cxft1.cxf.service.HelloSerivce", portName = "HelloServicePort")
@Component
public class HelloServiceImpl implements HelloSerivce {

    @Override
    public String sayHello(String name) {
        System.out.println("Hello " + name);
        return "Hello " + name;
    }

    @Override
    public User feedUser(User comsumer) {
        comsumer.setName("feeded");
        return comsumer;
    }

    @Override
    public HelloDateTestBean getHelloDateTestBean() {
        HelloDateTestBean hdt = new HelloDateTestBean();
        hdt.sethDate(new Date());
        return hdt;
    }

    @Override
    public Date getHelloDate() {
        return new Date();
    }
}
