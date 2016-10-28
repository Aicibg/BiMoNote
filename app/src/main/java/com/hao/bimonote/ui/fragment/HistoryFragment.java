package com.hao.bimonote.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.hao.bimonote.R;
import com.hao.bimonote.base.BaseFragment;

/**
 * Created by DongHao on 2016/10/28
 * Description:
 */

public class HistoryFragment extends BaseFragment {

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_history;
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
