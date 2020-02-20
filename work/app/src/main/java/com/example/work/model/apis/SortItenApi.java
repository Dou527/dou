package com.example.work.model.apis;

import com.example.work.model.bean.Sort_TabBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SortItenApi {
    @GET("catalog/index")
    Flowable<Sort_TabBean> getFenLeitemBean(@Query("id") int id);
}
