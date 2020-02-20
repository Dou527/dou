package com.example.work.interfaces.Sort;

import com.example.work.interfaces.IBaseView;
import com.example.work.interfaces.IPersenter;
import com.example.work.model.bean.SortBean;

public interface SortContract {
    interface View extends IBaseView {
        void FenLeiDataReturn(SortBean fenLeiBean);
    }

    interface Persenter extends IPersenter<View> {
        void getFenLeiData();
    }
}
