package com.example.work.model.apis;

import com.example.work.model.bean.HomeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface HomeApi {

    @GET("api/index/index")
    Flowable<HomeBean> getShouYeBean();
}
