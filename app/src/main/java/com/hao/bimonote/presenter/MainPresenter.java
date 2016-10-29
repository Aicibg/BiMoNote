package com.hao.bimonote.presenter;

import com.hao.bimonote.bean.NoteType;
import com.hao.bimonote.contract.MainContract;
import com.hao.bimonote.model.MainModel;

import java.util.List;

/**
 * Created by DongHao on 2016/10/30
 * Description:
 */

public class MainPresenter  extends MainContract.Presenter {

    public MainPresenter(MainContract.View view) {
        this.view=view;
        model=new MainModel();
    }

    @Override
    public void addNoteType() {
        view.goToNewType();
    }

    @Override
    public void initialized() {
        List<NoteType> list=model.getNoteType();
        if (list.size()==0){
            view.showMessage("你还没用新建笔记类型");
        }
        view.showNoteTypeList(list);
    }

    @Override
    public void detachView() {
        if (view!=null){
            view=null;
        }
    }
}
