package com.example.work.percenter;

import com.example.work.Utils.RxUtils;
import com.example.work.base.BasePersenter;
import com.example.work.interfaces.home.HomeContract;
import com.example.work.model.CommonSubscriber;
import com.example.work.model.bean.HomeBean;
import com.example.work.model.http.HttpManager;

public class HomePersenter extends BasePersenter<HomeContract.View> implements HomeContract.Persenter{

    @Override
    public void getHomeData() {
        addSubscribe(HttpManager.getHomeApi().getShouYeBean()
                .compose(RxUtils.<HomeBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<HomeBean>(mView){
                    @Override
                    public void onNext(HomeBean shouYeBean) {
                        mView.HomeDataReturn(shouYeBean);
                    }
                }));
    }
}
