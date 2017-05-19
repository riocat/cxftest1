package com.yang.cxft1.client.service;

import com.yang.cxft1.cxf.service.HelloSerivce;
import com.yang.cxft1.cxf.service.user.UserInfoService;
import com.yang.cxft1.interf.service.RoleService;
import com.yang.cxft1.interf.service.TeamService;
import com.yang.entry.user.User;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ASUS on 2017/5/14.
 */
public class TestService {

    public static void main(String[] args) {
        dynamicClientFactoryTest();

        jaxWsDynamicClientFactoryTest();

        normalTest();

        beanTest();

        roleTest();

        teamTest();

    }

    public static void dynamicClientFactoryTest() {
        DynamicClientFactory factory = DynamicClientFactory.newInstance();
        Client client = factory.createClient("http://localhost:80/service/helloService?wsdl");

        try {
            Object[] results = client.invoke("sayHello", "world");
            System.out.println(results[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void jaxWsDynamicClientFactoryTest() {
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://localhost:80/service/helloService?wsdl");

        try {
            Object[] results = client.invoke("sayHello", "world");
            System.out.println(results[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void normalTest() {
        ClassPathXmlApplicationContext cxa = new ClassPathXmlApplicationContext("springbase.xml");
        HelloSerivce helloSerivce = cxa.getBean("helloService", HelloSerivce.class);
        System.out.println(helloSerivce.sayHello("world"));
        com.yang.cxft1.cxf.service.User u = new com.yang.cxft1.cxf.service.User();
        u.setId(9);
        u.setName("ac");
        System.out.println(helloSerivce.feedUser(u).getName());
    }

    private static void beanTest() {

        ClassPathXmlApplicationContext cxa = new ClassPathXmlApplicationContext("springbase.xml");
        UserInfoService userInfoService = cxa.getBean("userInfoService", UserInfoService.class);

        User u = new User();
        u.setId(0);
        u.setName("user");
        u = userInfoService.getUser(u);
        System.out.println(u.getName());

        System.out.println(userInfoService.getUsers().size());

        System.out.println(userInfoService.getUserList().getUserList().size());

        System.out.println(userInfoService.getUserMap().getUserMap().getEntry().size());

/*
//        动态方式要求客户端的实体类必须和service接口在同一包下

//        DynamicClientFactory factory = DynamicClientFactory.newInstance();
//        Client client = factory.createClient("http://localhost:80/service/userInfoService?wsdl");

        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://localhost:80/service/helloService?wsdl");

        try {
            User u = new User();
            u.setId(0);
            u.setName("user");
            Object[] results = client.invoke("getUser", u);
            System.out.println(((User) results[0]).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Object[] results = client.invoke("getUsers");
            System.out.println(((User[]) results[0])[0].getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Object[] results = client.invoke("getUserList");
            System.out.println(((UserInfo) results[0]).getUserList().size());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Object[] results = client.invoke("getUserMap");
            System.out.println(((UserInfo) results[0]).getUserMap().getEntry().size());
        } catch (Exception e) {
            e.printStackTrace();
        }*/

/*
        // 以下方式会因为对象类型发生异常

        try {
            Object[] results = client.invoke("getUserList");
            System.out.println(((List<User>) results[0]).get(0).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Object[] results = client.invoke("getUserMap");
            System.out.println(((Map<String,User>) results[0]).entrySet().size());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Object[] results = client.invoke("getUserList");
            System.out.println(((ArrayList<User>) results[0]).get(0).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Object[] results = client.invoke("getUserMap");
            System.out.println(((HashMap<String,User>) results[0]).entrySet().size());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }


    private static void roleTest() {
        ClassPathXmlApplicationContext cxa = new ClassPathXmlApplicationContext("springbase.xml");
        RoleService roleService = cxa.getBean("roleService", RoleService.class);

        System.out.println(roleService.getRole().getRname());

        System.out.println(roleService.getRoleList().size());

        System.out.println(roleService.getRoleMap().size());

        System.out.println(roleService.getRoles().length);
    }

    private static void teamTest() {
        ClassPathXmlApplicationContext cxa = new ClassPathXmlApplicationContext("springbase.xml");
        TeamService teamService = cxa.getBean("teamService", TeamService.class);

        System.out.println(teamService.getTeam().getTname() + " " + teamService.getTeam().getCreateDate());

        System.out.println(teamService.getTeamList().getTeamList().size());

        System.out.println(teamService.getTeamMap().getTeamMap().size());

        System.out.println(teamService.getTeams().getTeams().length);

    }

}
