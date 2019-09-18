package com.liyan.custom;

import com.liyan.pojo.Role;
import com.liyan.pojo.Userlogin;
import org.springframework.stereotype.Repository;

/**
 * Userlogin扩展类
 */

public class UserloginCustom extends Userlogin {

    private Role role_ob;

    public void setRole(Role role) {
        this.role_ob = role_ob;
    }

    public Role getRole_ob() {
        return role_ob;
    }

}
