package com.hao.bimonote.model;

import com.hao.bimonote.bean.User;
import com.hao.bimonote.contract.LoginContract;
import com.hao.bimonote.utils.SpUtils;

/**
 * Created by DongHao on 2016/10/28
 * Description:
 */

public class LoginModel implements LoginContract.Model{
    @Override
    public User getUser() {
        User user=new User();
        user.setUserName((String) SpUtils.get("userName",null));
        user.setUserPassword((String) SpUtils.get("password",null));
        return user;
    }

    @Override
    public void saveUser(String name, String password) {
        SpUtils.put("userName",name);
        SpUtils.put("password",password);
    }
}
