package com.yang.cxft1.interf.entry;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2017/5/19.
 */
public class RoleInfo implements Serializable {

    private Role[] roles;

    private List<Role> roleList;

    private Map<String, Role> roleMap;

    public Role[] getRoles() {
        return roles;
    }

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Map<String, Role> getRoleMap() {
        return roleMap;
    }

    public void setRoleMap(Map<String, Role> roleMap) {
        this.roleMap = roleMap;
    }
}
