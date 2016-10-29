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
 * Created by DongHao on 2016/10/28
 * Description:
 */

public class HistoryFragment extends BaseFragment {

    @BindView(R.id.top_bar_title)
    TextView mTopBarTitle;

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_history;
    }

    @Override
    protected void initViews(View view, Bundle savedInstanceState) {
        mTopBarTitle.setText("历史记录");
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
