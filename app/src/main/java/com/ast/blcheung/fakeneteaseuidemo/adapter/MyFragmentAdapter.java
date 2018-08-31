package com.ast.blcheung.fakeneteaseuidemo.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ast.blcheung.fakeneteaseuidemo.ui.RecyclerViewFragment;

import java.util.List;

/**
 * @author Created by BLCheung
 * @email 925306022@qq.com
 * @date Created on 2018/8/29 14:44
 */
public class MyFragmentAdapter extends FragmentStatePagerAdapter {
    private List<String> titleList;
    private List<RecyclerViewFragment> fragmentList;

    public MyFragmentAdapter(FragmentManager fm, List<String> titleList, List<RecyclerViewFragment> fragmentList) {
        super(fm);
        this.titleList = titleList;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
