package com.yang.cxft1.cxf.service.impl;

import com.yang.cxft1.cxf.entry.User;
import com.yang.cxft1.cxf.service.weatherservice.WeatherService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * Created by ASUS on 2017/5/22.
 */
@WebService(targetNamespace = "http://weatherservice.service.cxf.cxft1.yang.com/",
        endpointInterface = "com.yang.cxft1.cxf.service.weatherservice.WeatherService", portName = "WeatherServicePort")
@Component
public class WeatherServiceImpl implements WeatherService {
    @Override
    public User sendInfoToUser(User user) {
        System.out.println("tell to " + user.getName());
        user.setName("konw");
        return user;
    }
}
