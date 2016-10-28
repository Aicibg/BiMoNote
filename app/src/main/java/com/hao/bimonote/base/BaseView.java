package com.hao.bimonote.base;

/**
 * Created by DongHao on 2016/10/27
 * Description:
 */

public interface BaseView {
    void close();

    void showMessage(String msg);
    void showErrorMessage(String msg);
}
