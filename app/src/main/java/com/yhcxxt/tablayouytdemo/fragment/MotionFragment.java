package com.yhcxxt.tablayouytdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yhcxxt.tablayouytdemo.R;

import butterknife.ButterKnife;

/**
 * <pre>
 *     author:LHT
 *     date:20190428
 *     desc:运动
 * </pre>
 */
public class MotionFragment extends LazyLoadFragment{
    @Override
    protected int setContentView() {
        return R.layout.fragment_study;
    }

    @Override
    protected void init() {
        ButterKnife.bind(this, rootView);
    }

    @Override
    protected void lazyLoad() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);
        return view;
    }
}
