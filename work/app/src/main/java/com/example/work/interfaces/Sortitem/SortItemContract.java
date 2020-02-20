package com.example.work.interfaces.Sortitem;

import com.example.work.interfaces.IBaseView;
import com.example.work.interfaces.IPersenter;
import com.example.work.model.bean.Sort_TabBean;

public interface SortItemContract {
    interface View extends IBaseView {
        void FenLeiItemDataReturn(Sort_TabBean fenLei_tabBean);
    }

    interface Persenter extends IPersenter<View> {
        void getFenLeiItemData(int id);
    }
}
