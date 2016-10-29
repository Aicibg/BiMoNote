package com.hao.bimonote.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.hao.bimonote.R;
import com.hao.library.base.BaseAppCompatFragment;

/**
 * Created by DongHao on 2016/10/29
 * Description:
 */

public class PersonalParentFragment extends BaseAppCompatFragment {

    public static PersonalParentFragment newInstance(){
          return new PersonalParentFragment();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_parent_personal;
    }

    @Override
    protected void initViews(View view, Bundle savedInstanceState) {
           loadRootFragment(R.id.parent_content,PersonalFragment.newInstance());
    }
}
