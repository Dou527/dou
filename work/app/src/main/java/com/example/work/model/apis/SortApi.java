package com.example.work.model.apis;

import com.example.work.model.bean.SortBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface SortApi {

    @GET("catalog/index")
    Flowable<SortBean> getFenLeiBean();
}
