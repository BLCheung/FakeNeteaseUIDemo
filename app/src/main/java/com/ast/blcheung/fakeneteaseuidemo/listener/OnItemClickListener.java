package com.ast.blcheung.fakeneteaseuidemo.listener;

import android.view.View;

/**
 * @author Created by BLCheung
 * @email 925306022@qq.com
 * @date Created on 2018/8/29 10:40
 */
public interface OnItemClickListener {
    /**
     * Handler RecyclerView Item Click
     * @param v The view that was clicked.
     * @param position Item position.
     */
    void onItemClick(View v, int position);
}
