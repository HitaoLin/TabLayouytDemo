package com.yhcxxt.tablayouytdemo.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yhcxxt.tablayouytdemo.R;
import com.yhcxxt.tablayouytdemo.adapter.FragmentAdapter;
import com.yhcxxt.tablayouytdemo.fragment.MotionFragment;
import com.yhcxxt.tablayouytdemo.fragment.StudyFragment;
import com.yhcxxt.tablayouytdemo.fragment.ThinkFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//黑色

        setContentView(R.layout.activity_main);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        initViewPager();

    }

    private void initViewPager() {
        mTabLayout = findViewById(R.id.tabs);
        List<String> titles = new ArrayList<>();
        titles.add("学习");
        titles.add("运动");
        titles.add("思考");
        titles.add("学习");
        titles.add("运动");
        titles.add("思考");

        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }


        fragments.add(new StudyFragment());
        fragments.add(new StudyFragment());
        fragments.add(new StudyFragment());
        fragments.add(new StudyFragment());
        fragments.add(new StudyFragment());
        fragments.add(new StudyFragment());


        FragmentAdapter mFragmentAdapteradapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        //给ViewPager设置适配器
        mViewPager.setAdapter(mFragmentAdapteradapter);
        //将TabLayout和ViewPager关联起来
        mTabLayout.setupWithViewPager(mViewPager);
        //给TabLayout设置适配器
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapteradapter);


    }


}
