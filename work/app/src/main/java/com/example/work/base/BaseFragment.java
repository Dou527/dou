package com.example.work.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.work.Utils.SystemUtils;
import com.example.work.interfaces.IBaseView;
import com.example.work.interfaces.IPersenter;

import butterknife.Unbinder;

public abstract class BaseFragment<V extends IBaseView,P extends IPersenter> extends Fragment implements IBaseView {

    protected Context context;
    protected P persenter;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        if(!SystemUtils.checkNetWork()){
//           view = inflater.inflate(R.layout.layout_network_error,null);
//            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }else{
            view = inflater.inflate(getLayout(),null);
            context = this.getContext();
            //unbinder = ButterKnife.bind(this,view);

            initView(view);
            persenter = createPersenter();
            persenter.attchView(this);
            initData();
        }
        return view;
    }

    //获取布局
    protected abstract int getLayout();

    //初始化布局
    protected abstract void initView(View view);

    //初始化数据
    protected abstract void initData();

    //创建P
    protected abstract P createPersenter();

    @Override
    public void onResume() {
        super.onResume();
        if(persenter != null){
            persenter.attchView(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(persenter != null){
            persenter.detachView();
        }
        if(unbinder != null){
            unbinder.unbind();
        }
    }
}
