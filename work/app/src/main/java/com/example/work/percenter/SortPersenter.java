package com.example.work.percenter;

import com.example.work.Utils.RxUtils;
import com.example.work.base.BasePersenter;
import com.example.work.interfaces.Sort.SortContract;
import com.example.work.model.CommonSubscriber;
import com.example.work.model.bean.SortBean;
import com.example.work.model.http.HttpManager;

public class SortPersenter extends BasePersenter<SortContract.View> implements SortContract.Persenter{

    @Override
    public void getFenLeiData() {
        addSubscribe(HttpManager.getFenLeiApi().getFenLeiBean()
                .compose(RxUtils.<SortBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<SortBean>(mView){
                    @Override
                    public void onNext(SortBean fenLeiBean) {
                        mView.FenLeiDataReturn(fenLeiBean);
                    }
                }));
    }
}
