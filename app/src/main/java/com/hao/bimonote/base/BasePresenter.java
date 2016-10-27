package com.hao.bimonote.base;

/**
 * Created by DongHao on 2016/10/27
 * Description:
 */

public interface BasePresenter<T extends BaseView, V extends BaseModel> {
    void detachView();
}
