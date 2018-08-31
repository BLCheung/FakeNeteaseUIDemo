package com.ast.blcheung.fakeneteaseuidemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ast.blcheung.fakeneteaseuidemo.R;
import com.ast.blcheung.fakeneteaseuidemo.listener.OnItemClickListener;

/**
 * @author Created by BLCheung
 * @email 925306022@qq.com
 * @date Created on 2018/8/29 10:48
 */
public class MyViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
    RelativeLayout rlRecyclerViewItem;
    ImageView ivRecyclerViewItem;
    TextView tvRecyclerViewItem;
    private OnItemClickListener listener;

    public MyViewholder(View itemView, OnItemClickListener listener) {
        super(itemView);
        this.listener = listener;
        rlRecyclerViewItem = (RelativeLayout) itemView;
        rlRecyclerViewItem.setOnClickListener(this);
        /** RecyclerView的控件绑定在此 **/
        ivRecyclerViewItem = rlRecyclerViewItem.findViewById(R.id.recycler_iv_item);
        tvRecyclerViewItem = rlRecyclerViewItem.findViewById(R.id.recycler_tv_item);
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(v, getAdapterPosition());
    }
}
