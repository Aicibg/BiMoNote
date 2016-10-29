package com.hao.bimonote.contract;

import com.hao.bimonote.base.BaseModel;
import com.hao.bimonote.base.BasePresenterMpl;
import com.hao.bimonote.base.BaseView;
import com.hao.bimonote.bean.NoteType;
import java.util.List;

/**
 * Created by DongHao on 2016/10/30
 * Description:
 */

public interface MainContract {

    interface Model extends BaseModel{
        List<NoteType> getNoteType();
    }

    interface View extends BaseView{
        void showNoteTypeList(List<NoteType> typeList);
        void goToNewType();
    }

    abstract class Presenter extends BasePresenterMpl<View,Model> {
          public abstract void  addNoteType();
    }
}
