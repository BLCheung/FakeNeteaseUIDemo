package com.ast.blcheung.fakeneteaseuidemo;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ast.blcheung.fakeneteaseuidemo.adapter.MyFragmentAdapter;
import com.ast.blcheung.fakeneteaseuidemo.ui.RecyclerViewFragment;
import com.ast.blcheung.fakeneteaseuidemo.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by BLCheung
 * @email 925306022@qq.com
 * @date Created on 2018/8/27 11:19
 */
public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private Toolbar toolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPage;
    private List<RecyclerViewFragment> fragmentList;
    private List<String> titleList;
    private MyFragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            // 设置状态栏颜色为透明
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        // 标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // 初始化控件
        initView();

    }

    private void initView() {
        mDrawerLayout = findViewById(R.id.main_dl);
        mNavigationView = findViewById(R.id.main_navigation);
        mTabLayout = findViewById(R.id.main_tab);
        mViewPage = findViewById(R.id.content_viewpage);

        // tab标签页
        initTab();

        // 设置DrawerLayout开关,并与Home图标联动
        mActionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                mDrawerLayout, toolbar, 0, 0);
        // 同步mDrawerLayout状态
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case android.R.id.home:
                        mDrawerLayout.openDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_camera:
                    case R.id.nav_contact:
                    case R.id.nav_discover:
                    case R.id.nav_email:
                    case R.id.nav_gallery:
                    case R.id.nav_home:
                    case R.id.nav_send:
                    case R.id.nav_share:
                    case R.id.nav_user:
                        ToastUtil.showToast(MainActivity.this, "" + item.getTitle());
                        break;

                    default:
                        break;
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void initTab() {
        titleList = new ArrayList<>();
        fragmentList = new ArrayList<>();

        titleList.add("时事");
        titleList.add("国内");
        titleList.add("国际");
        titleList.add("时政");
        titleList.add("体育");
        titleList.add("娱乐");
        titleList.add("头条");
        titleList.add("社会");
        titleList.add("时事");
        titleList.add("国内");
        titleList.add("国际");
        titleList.add("时政");
        titleList.add("体育");
        titleList.add("娱乐");
        titleList.add("头条");
        titleList.add("社会");

        for (int i = 0; i < titleList.size(); i++) {
            TabLayout.Tab tab = mTabLayout.newTab();
            tab.setText(titleList.get(i));
            mTabLayout.addTab(tab);
        }

        for (int i = 0; i < titleList.size(); i++) {
            fragmentList.add(new RecyclerViewFragment());
        }

        fragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), titleList, fragmentList);
        mViewPage.setAdapter(fragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPage);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_backup:
            case R.id.toolbar_locale:
            case R.id.toolbar_delete:
            case R.id.toolbar_setting:
                Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
