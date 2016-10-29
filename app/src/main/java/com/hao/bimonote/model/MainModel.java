package com.hao.bimonote.model;

import com.hao.bimonote.R;
import com.hao.bimonote.bean.NoteType;
import com.hao.bimonote.contract.MainContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DongHao on 2016/10/30
 * Description:
 */

public class MainModel implements MainContract.Model {
    private List<NoteType> mNoteTypeList;

    public MainModel() {
       mNoteTypeList=new ArrayList<>();
    }

    @Override
    public List<NoteType> getNoteType() {
        for(int i=0;i<6;i++){
            NoteType noteType=new NoteType();
            noteType.setTypeImageId(R.mipmap.note_selected0);
            noteType.setTypeName("笔记类型"+(i+1));
            if (i==5){
                noteType.setTypeName("新建笔记类型");
            }
            mNoteTypeList.add(noteType);
        }
        return mNoteTypeList;
    }

}
