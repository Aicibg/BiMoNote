package com.hao.bimonote.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.dhao.eventbuslibrary.EventBus;
import com.dhao.eventbuslibrary.meta.EventCenter;
import com.hao.bimonote.R;
import com.hao.bimonote.base.BaseActivity;
import com.hao.bimonote.ui.fragment.HistoryFragment;
import com.hao.bimonote.ui.fragment.HistoryParentFragment;
import com.hao.bimonote.ui.fragment.MainFragment;
import com.hao.bimonote.ui.fragment.MainParentFragment;
import com.hao.bimonote.ui.fragment.PersonalFragment;
import com.hao.bimonote.ui.fragment.PersonalParentFragment;
import com.hao.bimonote.utils.Constant;
import com.hao.library.base.BaseAppCompatFragment;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNavigation;

    private BaseAppCompatFragment[] fragments = new BaseAppCompatFragment[3];
    private int prePosition = 0;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            fragments[0] = MainParentFragment.newInstance();
            fragments[1] = HistoryParentFragment.newInstance();
            fragments[2] = PersonalParentFragment.newInstance();
            loadMultipleRootFragment(R.id.frame_content, 0, fragments);
        } else {
            fragments[0] = findFragment(MainParentFragment.class);
            fragments[1] = findFragment(HistoryParentFragment.class);
            fragments[2] = findFragment(PersonalParentFragment.class);
        }

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int position = 0;
                switch (item.getItemId()) {
                    case R.id.item_main:
                        showHideFragment(fragments[0], fragments[prePosition]);
                        prePosition = 0;
                        position = 0;
                        break;
                    case R.id.item_personal:
                        showHideFragment(fragments[2], fragments[prePosition]);
                        prePosition = 2;
                        position = 0;
                        break;
                    case R.id.item_class:
                        showHideFragment(fragments[1], fragments[prePosition]);
                        prePosition = 1;
                        position = 0;
                        break;
                    default:
                        break;
                }
                SupportFragment currentFragment = fragments[position];
                int count = currentFragment.getChildFragmentManager().getBackStackEntryCount();
                if (count > 1) {
                    if (currentFragment instanceof MainParentFragment) {
                        currentFragment.popToChild(MainFragment.class, false);
                    } else if (currentFragment instanceof HistoryParentFragment) {
                        currentFragment.popToChild(HistoryFragment.class, false);
                    } else if (currentFragment instanceof PersonalParentFragment) {
                        currentFragment.popToChild(PersonalFragment.class, false);
                    }
                }
                if (count == 1) {
                    EventBus.getDefault().post(new EventCenter<>(Constant.EVENT_REFRESH, position));
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
