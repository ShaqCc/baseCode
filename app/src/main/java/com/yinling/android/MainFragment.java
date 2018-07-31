package com.yinling.android;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yinling.android.base.ui.LazyFragment;

/**
 * Created by 巴银 on 2018/7/30.
 * 功能：
 */

public class MainFragment extends LazyFragment {

    private View mRootView;
    private ProgressBar mProgressBar;
    private TextView mTvContent;
    private Handler mHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    mTvContent.setVisibility(View.VISIBLE);
                    mProgressBar.setVisibility(View.GONE);
                    mTvContent.setText(getTitle());
                    break;
            }
        }
    };

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_main_layout, container, false);
        mProgressBar = mRootView.findViewById(R.id.main_fragment_progressbar);
        mTvContent = mRootView.findViewById(R.id.main_fragment_tv_content);
        return mRootView;
    }

    @Override
    protected void initData() {
        mTvContent.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
        mHandler.sendEmptyMessageDelayed(0,2000);
    }

    @Override
    protected void setDefaultFragmentTitle(String title) {
        setTitle(title);
    }
}
