package com.hao.bimonote.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hao.library.base.BaseAppCompatFragment;

import butterknife.ButterKnife;

/**
 * Created by DongHao on 2016/10/28
 * Description:
 */

public abstract class BaseFragment<V extends BasePresenter> extends BaseAppCompatFragment implements BaseView {
    protected V mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
