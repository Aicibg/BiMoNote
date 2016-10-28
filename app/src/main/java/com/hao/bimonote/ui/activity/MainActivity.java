package com.hao.bimonote.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.widget.TextView;
import com.hao.bimonote.R;
import com.hao.bimonote.base.BaseActivity;
import com.hao.bimonote.base.BaseFragment;
import com.hao.bimonote.ui.fragment.HistoryFragment;
import com.hao.bimonote.ui.fragment.MainFragment;
import com.hao.bimonote.ui.fragment.PersonalFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNavigation;
    @BindView(R.id.top_bar_title)
    TextView mTopBarTitle;

    private BaseFragment[] fragments=new BaseFragment[3];
    private int prePosition=0;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mTopBarTitle.setText("笔墨");
        if (savedInstanceState==null){
            fragments[0]= MainFragment.newInstance();
            fragments[1]= HistoryFragment.newInstance();
            fragments[2]= PersonalFragment.newInstance();
            loadMultipleRootFragment(R.id.frame_content,0,fragments);
        }else {
            fragments[0]=findFragment(MainFragment.class);
            fragments[1]=findFragment(HistoryFragment.class);
            fragments[2]=findFragment(PersonalFragment.class);
        }

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_main:
                       showHideFragment(fragments[0],fragments[prePosition]);
                        prePosition=0;
                        mTopBarTitle.setText("笔墨");
                        break;
                    case R.id.item_personal:
                        showHideFragment(fragments[2],fragments[prePosition]);
                        prePosition=2;
                        mTopBarTitle.setText("个人中心");
                        break;
                    case R.id.item_class:
                        showHideFragment(fragments[1],fragments[prePosition]);
                        prePosition=1;
                        mTopBarTitle.setText("历史记录");
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
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
