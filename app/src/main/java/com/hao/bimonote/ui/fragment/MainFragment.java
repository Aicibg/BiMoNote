package com.hao.bimonote.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.hao.bimonote.R;
import com.hao.bimonote.adapter.NoteTypeListAdapter;
import com.hao.bimonote.base.BaseFragment;
import com.hao.bimonote.bean.NoteType;
import com.hao.bimonote.contract.MainContract;
import com.hao.bimonote.presenter.MainPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by DongHao on 2016/10/27
 * Description:
 */

public class MainFragment extends BaseFragment<MainPresenter> implements MainContract.View{

    @BindView(R.id.top_bar_title)
    TextView mTopBarTitle;
    @BindView(R.id.type_list)
    RecyclerView mTypeList;
    private NoteTypeListAdapter noteTypeListAdapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initViews(View view, Bundle savedInstanceState) {
        mTopBarTitle.setText("我的笔记");
        mPresenter=new MainPresenter(this);
        mPresenter.initialized();
    }

    @Override
    public void close() {

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(_mActivity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(String msg) {

    }

    @Override
    public void showNoteTypeList(List<NoteType> typeList) {
        noteTypeListAdapter=new NoteTypeListAdapter();
        noteTypeListAdapter.addAll(typeList);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mTypeList.setLayoutManager(layoutManager);
        mTypeList.setAdapter(noteTypeListAdapter);
    }

    @Override
    public void goToNewType() {

    }
}
