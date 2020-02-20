package com.example.work.Utils;

import android.content.Context;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataUtlis {

    private static String json;

    public static String getBean(Context con){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new  Request.Builder()
                .get()
                .url("https://cdwan.cn/api/index/index")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                json = response.body().string();

            }
        });
        return json;
    }
}
