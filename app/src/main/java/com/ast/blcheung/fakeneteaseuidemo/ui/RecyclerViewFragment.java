package com.ast.blcheung.fakeneteaseuidemo.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ast.blcheung.fakeneteaseuidemo.R;
import com.ast.blcheung.fakeneteaseuidemo.adapter.RecyclerViewAdapter;
import com.ast.blcheung.fakeneteaseuidemo.listener.OnItemClickListener;
import com.ast.blcheung.fakeneteaseuidemo.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by BLCheung
 * @email 925306022@qq.com
 * @date Created on 2018/8/29 11:46
 */
public class RecyclerViewFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<String> dataList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        recyclerView = view.findViewById(R.id.content_fragment_recyclerview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dataList = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            dataList.add("我是第" + i + "个");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(dataList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                ToastUtil.showToast(getContext(), "你点击了：" + dataList.get(position));
            }
        });

    }

}
