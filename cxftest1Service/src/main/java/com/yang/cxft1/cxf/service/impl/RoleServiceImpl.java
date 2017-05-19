package com.yang.cxft1.cxf.service.impl;

import com.yang.cxft1.interf.entry.Role;
import com.yang.cxft1.interf.service.RoleService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2017/5/19.
 */
@WebService(targetNamespace = "http://service.interf.cxft1.yang.com/", portName = "RoleServicePort",
        endpointInterface = "com.yang.cxft1.interf.service.RoleService")
@Component
public class RoleServiceImpl implements RoleService {
    @Override
    public Role getRole() {
        Role role = new Role();
        role.setRname("rolea");
        return role;
    }

    @Override
    public Role[] getRoles() {
        Role role1 = new Role();
        role1.setId(0);
        role1.setRname("rolea");
        Role role2 = new Role();
        role2.setId(1);
        role2.setRname("roleb");
        Role[] roles = {role1, role2};
        return roles;
    }

    @Override
    public List<Role> getRoleList() {
        List<Role> list = new ArrayList<Role>();
        Role role1 = new Role();
        role1.setId(2);
        role1.setRname("rolec");
        list.add(role1);
        Role role2 = new Role();
        role2.setId(3);
        role2.setRname("roled");
        list.add(role2);
        return list;
    }

    @Override
    public Map<String, Role> getRoleMap() {

        Map<String, Role> map = new HashMap<String, Role>();

        Role role1 = new Role();
        role1.setId(4);
        role1.setRname("rolee");
        Role role2 = new Role();
        role2.setId(5);
        role2.setRname("rolef");

        map.put("a",role1);
        map.put("b",role2);

        return map;
    }
}
