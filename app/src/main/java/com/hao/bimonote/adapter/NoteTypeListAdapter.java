package com.hao.bimonote.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hao.bimonote.R;
import com.hao.bimonote.bean.NoteType;
import com.hao.library.adapter.BaseRecycleOneTypeAdapter;
import com.hao.library.adapter.BaseRecycleViewHolder;
import com.hao.library.utils.DensityUtils;

import butterknife.BindView;

/**
 * Created by DongHao on 2016/10/29
 * Description:
 */

public class NoteTypeListAdapter extends BaseRecycleOneTypeAdapter<NoteType, NoteTypeListAdapter.MyViewHolder> {
    int a=0;
    int b=0;
    @Override
    protected void bindView(MyViewHolder holder, int position) {
        holder.tvNoteType.setText(getData().get(position).getTypeName());
        holder.ivNoteTYpe.setImageResource(getData().get(position).getTypeImageId());
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (position % 2 == 0) {
            lp.height = a;
        } else {
            lp.height = b;
        }
        holder.itemView.setLayoutParams(lp);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note_type, parent, false);
        a=DensityUtils.dp2px(parent.getContext(),220);
        b=DensityUtils.dp2px(parent.getContext(),150);
        return new MyViewHolder(itemView);
    }

    public class MyViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_note_type)
        TextView tvNoteType;
        @BindView(R.id.iv_note_type)
        ImageView ivNoteTYpe;
        public View itemView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }
}
