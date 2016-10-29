package com.hao.bimonote.base;

/**
 * Created by DongHao on 2016/10/27
 * Description:
 */

public abstract class BasePresenterMpl<T extends BaseView, V extends BaseModel> implements BasePresenter{
    protected T view;
    protected V model;
}
