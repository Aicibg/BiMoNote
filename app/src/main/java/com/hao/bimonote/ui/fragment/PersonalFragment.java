package com.hao.bimonote.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hao.bimonote.R;
import com.hao.bimonote.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DongHao on 2016/10/27
 * Description:
 */

public class PersonalFragment extends BaseFragment {

    @BindView(R.id.top_bar_title)
    TextView mTopBarTitle;

    public static PersonalFragment newInstance() {
        return new PersonalFragment();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void initViews(View view, Bundle savedInstanceState) {
       mTopBarTitle.setText("个人中心");
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
