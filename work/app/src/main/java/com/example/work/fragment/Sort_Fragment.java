package com.example.work.fragment;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.work.GoodsDescActivity;
import com.example.moni.R;
import com.example.work.adapter.Rec_sortAdapter;
import com.example.work.base.BaseFragment;
import com.example.work.interfaces.IPersenter;
import com.example.work.interfaces.Sortitem.SortItemContract;
import com.example.work.model.bean.Sort_TabBean;
import com.example.work.percenter.SortItemPersenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;


public class Sort_Fragment extends BaseFragment implements SortItemContract.View {
    private List<Sort_TabBean.DataBean.CategoryListBean> tablist;
    private RecyclerView rec;
    private Rec_sortAdapter adapter;
    private ImageView img_fenlei;
    private TextView tv_fenlei;
    private int posi = 0;

    @Override
    protected int getLayout() {
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
        return R.layout.fragment_sort_;
    }

    @Override
    protected void initView(View view) {
        rec = view.findViewById(R.id.rec_fenlei);
        img_fenlei = view.findViewById(R.id.iv_fenlei);
        tv_fenlei = view.findViewById(R.id.tv_fenlei_lei);
        rec.setLayoutManager(new GridLayoutManager(getActivity(),3));

        tablist = new ArrayList<>();
        adapter = new Rec_sortAdapter(tablist, getActivity());
        rec.setAdapter(adapter);

        adapter.setOnClick(new Rec_sortAdapter.OnClick() {
            @Override
            public void OnItemClick(int position) {
                ArrayList<Sort_TabBean.DataBean.CategoryListBean> list = new ArrayList<>();
                list.addAll(tablist);
                Intent intent = new Intent(context, GoodsDescActivity.class);
                intent.putExtra("data",list);
                intent.putExtra("posi",position);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        ((SortItemPersenter)persenter).getFenLeiItemData(posi);
    }

    @Subscribe
    public void getPosi(String position){
        posi = Integer.parseInt(position);
        ((SortItemPersenter)persenter).getFenLeiItemData(posi);
    }

    @Override
    protected IPersenter createPersenter() {
        return new SortItemPersenter();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void FenLeiItemDataReturn(Sort_TabBean fenLei_tabBean) {
        List<Sort_TabBean.DataBean.CategoryListBean> categoryList = fenLei_tabBean.getData().getCategoryList();
        tv_fenlei.setText(categoryList.get(posi).getFront_desc());
        Glide.with(context).load(categoryList.get(posi).getWap_banner_url()).into(img_fenlei);
        tablist.clear();
        tablist.addAll(categoryList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String err) {

    }
}
