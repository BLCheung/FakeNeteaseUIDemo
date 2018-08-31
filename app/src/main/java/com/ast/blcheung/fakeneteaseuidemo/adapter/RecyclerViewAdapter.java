package com.ast.blcheung.fakeneteaseuidemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ast.blcheung.fakeneteaseuidemo.R;
import com.ast.blcheung.fakeneteaseuidemo.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by BLCheung
 * @email 925306022@qq.com
 * @date Created on 2018/8/29 11:10
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewholder> {
    private List<String> dataList;
    private Context context;
    private OnItemClickListener listener;
    private RequestOptions options = new RequestOptions()
            .override(96, 96)
            .placeholder(R.mipmap.ic_launcher)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

    public RecyclerViewAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewholder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.tvRecyclerViewItem.setText(dataList.get(position));
        Glide.with(context)
                .load(R.mipmap.headericon_2)
                .apply(options)
                .into(holder.ivRecyclerViewItem);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * 暴露给外部调用的点击事件
     *
     * @param listener RecyclerView item点击事件
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
