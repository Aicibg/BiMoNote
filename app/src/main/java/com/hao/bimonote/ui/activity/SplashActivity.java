package com.hao.bimonote.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.hao.bimonote.R;
import com.hao.bimonote.base.BaseActivity;
import com.hao.bimonote.base.BasePresenter;
import com.hao.bimonote.ui.MainActivity;

import butterknife.BindView;

public class SplashActivity extends BaseActivity<BasePresenter> {

    @BindView(R.id.bt_start_open)
    Button mBtStartOpen;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_splish;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
       mBtStartOpen.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(SplashActivity.this,LoginActivity.class));
           }
       });
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return true;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.SCALE;
    }
}
