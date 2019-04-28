package com.yhcxxt.tablayouytdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yhcxxt.tablayouytdemo.R;
import com.yhcxxt.tablayouytdemo.utils.HttpUtils;
import com.yhcxxt.tablayouytdemo.views.IosLoadDialog;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * <pre>
 *     author:LHT
 *     date:20190428
 *     desc:学习
 * </pre>
 */
public class StudyFragment extends LazyLoadFragment{

    @BindView(R.id.tv_study)
    TextView tv_study;

    IosLoadDialog dialog;

//    String url = "https://www.baidu.com/";
    String url = "https://wanandroid.com/wxarticle/list/405/1/json?k=Java";
    String data;


    @Override
    protected int setContentView() {
        return R.layout.fragment_study;
    }

    @Override
    protected void init() {
        ButterKnife.bind(this, rootView);
        dialog = new IosLoadDialog(getActivity());
    }

    //加载数据
    @Override
    protected void lazyLoad() {

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                dialog.show();

            }
        });


        HttpUtils.sendData(url, "", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(mActivity, "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                data = response.body().string();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        tv_study.setText(data);

                        dialog.dismiss();

                    }
                });


            }
        });


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);
        return view;
    }
}
