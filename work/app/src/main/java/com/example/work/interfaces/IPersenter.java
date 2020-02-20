package com.example.work.interfaces;

public interface IPersenter<V extends IBaseView> {

    void attchView(V view);

    void detachView();

}
