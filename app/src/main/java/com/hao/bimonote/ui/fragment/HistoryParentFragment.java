package com.hao.bimonote.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hao.bimonote.R;
import com.hao.bimonote.base.BaseFragment;
import com.hao.library.base.BaseAppCompatFragment;

import butterknife.BindView;

/**
 * Created by DongHao on 2016/10/28
 * Description:
 */

public class HistoryParentFragment extends BaseAppCompatFragment {

    public static HistoryParentFragment newInstance(){
          return new HistoryParentFragment();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_parent_history;
    }

    @Override
    protected void initViews(View view, Bundle savedInstanceState) {
         loadRootFragment(R.id.parent_content,HistoryFragment.newInstance());
    }



}
