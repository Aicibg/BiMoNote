package com.hao.bimonote.model;

import com.hao.bimonote.NoteApplication;
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
        user.setUserName((String) NoteApplication.mSpUtils.get("userName","-1"));
        user.setUserPassword((String) NoteApplication.mSpUtils.get("password","-1"));
        return user;
    }

    @Override
    public void saveUser(String name, String password) {
        NoteApplication.mSpUtils.put("userName",name);
        NoteApplication.mSpUtils.put("password",password);
    }
}
