package com.example.work.percenter;

import com.example.work.Utils.RxUtils;
import com.example.work.base.BasePersenter;
import com.example.work.interfaces.Sortitem.SortItemContract;
import com.example.work.model.CommonSubscriber;
import com.example.work.model.bean.Sort_TabBean;
import com.example.work.model.http.HttpManager;

public class SortItemPersenter extends BasePersenter<SortItemContract.View> implements SortItemContract.Persenter {
    @Override
    public void getFenLeiItemData(int id) {
        addSubscribe(HttpManager.getFenLeiItemApi().getFenLeitemBean(id)
                .compose(RxUtils.<Sort_TabBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<Sort_TabBean>(mView){
                    @Override
                    public void onNext(Sort_TabBean fenLei_tabBean) {
                        mView.FenLeiItemDataReturn(fenLei_tabBean);
                    }
                }));
    }
}
