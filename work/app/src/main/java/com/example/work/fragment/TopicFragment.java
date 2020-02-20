package com.example.work.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moni.R;
import com.example.work.adapter.Rec_topicAdapter;
import com.example.work.base.BaseFragment;
import com.example.work.interfaces.IPersenter;
import com.example.work.interfaces.home.HomeContract;
import com.example.work.model.bean.HomeBean;
import com.example.work.percenter.HomePersenter;

import java.util.ArrayList;
import java.util.List;

public class TopicFragment extends BaseFragment implements HomeContract.View {


    private RecyclerView rec;
    private List<HomeBean.DataBean.TopicListBean> list;
    private Rec_topicAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_topic;
    }

    @Override
    protected void initView(View view) {
        rec = view.findViewById(R.id.rec_zhuanti);
        rec.setLayoutManager(new LinearLayoutManager(context));
        list = new ArrayList<>();
        adapter = new Rec_topicAdapter(list, context);
        rec.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        ((HomePersenter)persenter).getHomeData();
    }

    @Override
    protected IPersenter createPersenter() {
        return new HomePersenter();
    }

    @Override
    public void HomeDataReturn(HomeBean shouYeBean) {
        List<HomeBean.DataBean.TopicListBean> topicList = shouYeBean.getData().getTopicList();
        list.addAll(topicList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String err) {

    }
}
