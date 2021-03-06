package com.hao.bimonote.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;

import com.hao.library.base.BaseAppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by DongHao on 2016/10/27
 * Description:
 */

public abstract class BaseActivity <V extends BasePresenterMpl>extends BaseAppCompatActivity implements BaseView {
    protected V mPresenter;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
