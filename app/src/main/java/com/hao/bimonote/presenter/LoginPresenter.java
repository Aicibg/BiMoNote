package com.hao.bimonote.presenter;

import android.text.TextUtils;

import com.hao.bimonote.bean.User;
import com.hao.bimonote.contract.LoginContract;
import com.hao.bimonote.model.LoginModel;

/**
 * Created by DongHao on 2016/10/28
 * Description:
 */

public class LoginPresenter extends LoginContract.Presenter {

    public LoginPresenter(LoginContract.View loginView) {
        view = loginView;
        model = new LoginModel();
    }

    @Override
    public void login(String name, String password) {
        view.showProgress("正在加载");
        User user=model.getUser();
        if (!TextUtils.isEmpty(name) & !TextUtils.isEmpty(password)) {
            if (name.equals(user.getUserName()) & password.equals(user.getUserPassword())) {
                view.loginSuccess();
            } else {
                view.loginFailed();
            }
        } else {
            view.showErrorMessage("请输入用户名或密码！");
        }
        view.hideProgress();
    }

    @Override
    public void saveUser(String name, String password) {
        model.saveUser(name, password);
        view.showMessage("保存成功");
    }


    @Override
    public void initialized() {

    }

    @Override
    public void detachView() {
           if (view!=null){
               view=null;
           }
    }
}
