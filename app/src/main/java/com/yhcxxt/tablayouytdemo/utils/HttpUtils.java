package com.yhcxxt.tablayouytdemo.utils;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * 联网类
 * Created by IOT-STU on 2018-06-22.
 */

public class HttpUtils {
    /**
     * 请求
     */
    public static void sendData(String url, String dataJson, Callback callback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), dataJson);
        Request request = new Request.Builder().url(url).post(body).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
