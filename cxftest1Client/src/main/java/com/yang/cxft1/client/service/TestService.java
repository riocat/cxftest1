package com.yang.cxft1.client.service;

import com.yang.cxft1.cxf.service.HelloDateTestBean;
import com.yang.cxft1.cxf.service.HelloSerivce;
import com.yang.cxft1.cxf.service.user.UserInfoService;
import com.yang.cxft1.cxf.service.weatherservice.WeatherService;
import com.yang.cxft1.interf.entry.Role;
import com.yang.cxft1.interf.entry.team.Team;
import com.yang.cxft1.interf.service.RoleService;
import com.yang.cxft1.interf.service.TeamService;
import com.yang.entry.user.User;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

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

        teamT();

        helloDateTest();

        weatherTest();

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

        // 非spring的普通用法
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setAddress("http://localhost/service/roleService");
        factory.setServiceClass(RoleService.class);

        RoleService rs = factory.create(RoleService.class);
        List<Role> roles = rs.getRoleList();
        System.out.println(roles.get(0).getRname());
    }

    private static void teamTest() {
        ClassPathXmlApplicationContext cxa = new ClassPathXmlApplicationContext("springbase.xml");
        TeamService teamService = cxa.getBean("teamService", TeamService.class);

        System.out.println(teamService.getTeam().getTname() + " " + teamService.getTeam().getCreateDate());

        System.out.println(teamService.getTeamList().getTeamList().size());

        System.out.println(teamService.getTeamMap().getTeamMap().size());

        System.out.println(teamService.getTeams().getTeams().length);

        Team temp = new Team();
        temp.setId(99);
        temp.setTname("Falcons");
        temp.setCreateDate(new Date());
        System.out.println(teamService.initTeam(temp));

       /*
       实体类包名限制发生异常
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://localhost:80/service/TeamService?wsdl");

        try {
            Object[] results = client.invoke("getTeam");
            System.out.println(((Team)results[0]).getTname());
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

    public static void teamT() {
        ClassPathXmlApplicationContext cxa = new ClassPathXmlApplicationContext("springbase.xml");
        TeamService teamService = cxa.getBean("teamService", TeamService.class);
        Date date = teamService.getTeam().getCreateDate();
        System.out.println(date.getClass().getName());
    }


    private static void helloDateTest() {
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://localhost:80/service/helloService?wsdl");

        try {
            Object[] results = client.invoke("getHelloDateTestBean");
            HelloDateTestBean hdt = (HelloDateTestBean) results[0];
            System.out.println(hdt.getHDate().getClass().getName());
            System.out.println(hdt.getHDate());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Object[] results = client.invoke("getHelloDate");
            Date hdt = (Date) results[0];
            System.out.println(hdt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------------");

        DynamicClientFactory dCFactory = DynamicClientFactory.newInstance();
        Client dCClient = dCFactory.createClient("http://localhost:80/service/helloService?wsdl");

        try {
            Object[] results = dCClient.invoke("getHelloDateTestBean");
            System.out.println(((HelloDateTestBean) results[0]).getHDate().getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Object[] results = dCClient.invoke("getHelloDate");
            System.out.println(results[0].getClass().getName());
            System.out.println(results[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------------");

        JaxWsDynamicClientFactory jDFactory = JaxWsDynamicClientFactory.newInstance();
        Client jDClient = jDFactory.createClient("http://localhost:80/service/helloService?wsdl");

        try {
            Object[] results = jDClient.invoke("getHelloDateTestBean");
            System.out.println(((HelloDateTestBean) results[0]).getHDate().getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Object[] results = jDClient.invoke("getHelloDate");
            System.out.println(results[0].getClass().getName());
            System.out.println(results[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------------");

        ClassPathXmlApplicationContext cxa = new ClassPathXmlApplicationContext("springbase.xml");
        HelloSerivce helloSerivce = cxa.getBean("helloService", HelloSerivce.class);
        System.out.println(helloSerivce.getHelloDateTestBean().getHDate());
        System.out.println(helloSerivce.getHelloDateTestBean().getHDate().getClass().getName());
        System.out.println(helloSerivce.getHelloDate());
        System.out.println(helloSerivce.getHelloDate().getClass());
    }


    private static void weatherTest() {

        DynamicClientFactory Factory = DynamicClientFactory.newInstance();
        Client client = Factory.createClient("http://localhost/service/WeatherService?wsdl");

        com.yang.cxft1.cxf.service.weatherservice.User u = new com.yang.cxft1.cxf.service.weatherservice.User();
        try {
            u.setName("ad");
            Object[] results = client.invoke("sendInfoToUser", u);
            System.out.println(((com.yang.cxft1.cxf.service.weatherservice.User) results[0]).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ClassPathXmlApplicationContext cxa = new ClassPathXmlApplicationContext("springbase.xml");
        WeatherService weatherService = cxa.getBean("weatherService", WeatherService.class);
        u = weatherService.sendInfoToUser(u);
        System.out.println(u.getName());
    }

}
