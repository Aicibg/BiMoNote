package com.hao.bimonote.adapter;

import android.view.View;
import com.hao.library.adapter.BaseRecycleViewHolder;
import butterknife.ButterKnife;

/**
 * Created by DongHao on 2016/10/29
 * Description:
 */

public class BaseViewHolder extends BaseRecycleViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

}
