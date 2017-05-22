package com.yang.cxft1.cxf.service.weatherservice;

import com.yang.cxft1.cxf.entry.User;

import javax.jws.WebService;

/**
 * Created by ASUS on 2017/5/22.
 */
@WebService
public interface WeatherService {

    User sendInfoToUser(User user);
}
