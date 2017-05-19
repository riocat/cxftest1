package com.yang.cxft1.interf.service;

import com.yang.cxft1.interf.entry.Role;
import com.yang.cxft1.interf.entry.RoleInfo;

import javax.jws.WebService;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2017/5/19.
 */
@WebService
public interface RoleService {

    public Role getRole();
    public Role[] getRoles();
    public List<Role> getRoleList();
    public Map<String,Role> getRoleMap();
}
