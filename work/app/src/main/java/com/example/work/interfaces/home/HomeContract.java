package com.example.work.interfaces.home;

import com.example.work.interfaces.IBaseView;
import com.example.work.interfaces.IPersenter;
import com.example.work.model.bean.HomeBean;

public interface HomeContract {
    interface View extends IBaseView {
        void HomeDataReturn(HomeBean shouYeBean);
    }

    interface Persenter extends IPersenter<View> {
        void getHomeData();
    }
}
