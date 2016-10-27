package com.hao.bimonote;

import android.app.Application;

import com.hao.bimonote.utils.SpUtils;

/**
 * Created by DongHao on 2016/10/28
 * Description:
 */

public class NoteApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SpUtils.init(getApplicationContext());
    }
}
