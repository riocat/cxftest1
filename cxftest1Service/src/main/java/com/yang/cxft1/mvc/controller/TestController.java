package com.yang.cxft1.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 2017/5/12.
 */
@Controller
@RequestMapping("testCon")
public class TestController {

    @RequestMapping("tojsppage")
    public String toJSPPage(HttpServletRequest request){
        request.setAttribute("flage","NE");
        return "springMVCTest";
    }
}
