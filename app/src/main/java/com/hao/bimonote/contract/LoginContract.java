package com.hao.bimonote.contract;

import com.hao.bimonote.base.BaseModel;
import com.hao.bimonote.base.BasePresenterMpl;
import com.hao.bimonote.base.BaseView;
import com.hao.bimonote.bean.User;

/**
 * Created by DongHao on 2016/10/28
 * Description:
 */

public interface LoginContract {
    interface Model extends BaseModel {
        User getUser();

        void saveUser(String name, String password);
    }

    interface View extends BaseView {
        void showProgress(String msg);

        void hideProgress();

        void loginSuccess();

        void loginFailed();
    }

    abstract class Presenter extends BasePresenterMpl<View, Model> {

        public abstract void login(String name, String password);

        public abstract void saveUser(String name, String password);

    }
}
