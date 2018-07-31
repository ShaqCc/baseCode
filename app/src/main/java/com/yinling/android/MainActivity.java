package com.yinling.android;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yinling.android.base.ui.LazyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<LazyFragment> mLazyFragments = new ArrayList<>();
    private String[] titleArray = {"首页", "新闻", "娱乐", "爆料", "国内",};
    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tabLayout);
        mBottomNavigationView = findViewById(R.id.design_navigation_view);

        initFragments();

        mViewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);

        //design_navigation_view
    }

    private void initFragments() {
        for (int i = 0; i < titleArray.length; i++) {
            MainFragment mainFragment = new MainFragment();
            mainFragment.setTitle(titleArray[i]);
            mLazyFragments.add(mainFragment);
            //tablayout
            mTabLayout.getTabAt(i).setText(titleArray[i]);
        }
    }

    private class MyPageAdapter extends FragmentPagerAdapter {
        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mLazyFragments.get(position);
        }

        @Override
        public int getCount() {
            return mLazyFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (getItem(position) instanceof LazyFragment) {
                return ((LazyFragment) getItem(position)).getTitle();
            }
            return super.getPageTitle(position);
        }
    }
}
