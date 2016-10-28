package com.hao.bimonote.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.hao.bimonote.R;
import com.hao.bimonote.base.BaseFragment;

/**
 * Created by DongHao on 2016/10/27
 * Description:
 */

public class PersonalFragment extends BaseFragment {

    public static PersonalFragment newInstance() {
        return new PersonalFragment();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void initViews(View view, Bundle savedInstanceState) {

    }

    @Override
    public void close() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showErrorMessage(String msg) {

    }


}
