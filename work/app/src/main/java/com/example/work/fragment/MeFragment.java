package com.example.work.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.moni.R;
import com.example.work.adapter.Rec_MeAdapter;
import com.example.work.model.bean.MeBean;

import java.util.ArrayList;

public class MeFragment extends Fragment {
    private ImageView ivMeTouxiang;
    private TextView tvMeName;
    private ImageView ivJiantou;
    private RecyclerView recMe;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initRec();
    }

    private void initRec() {
        ArrayList<MeBean> Mes = new ArrayList<>();
        Mes.add(new MeBean(R.mipmap.a,"我的订单"));
        Mes.add(new MeBean(R.mipmap.q,"优惠券"));
        Mes.add(new MeBean(R.mipmap.b,"礼品卡"));
        Mes.add(new MeBean(R.mipmap.c,"我的收藏"));
        Mes.add(new MeBean(R.mipmap.d,"我的足迹"));
        Mes.add(new MeBean(R.mipmap.e,"会员福利"));
        Mes.add(new MeBean(R.mipmap.c,"地址管理"));
        Mes.add(new MeBean(R.mipmap.d,"账号安全"));
        Mes.add(new MeBean(R.mipmap.e,"联系客服"));
        Mes.add(new MeBean(R.mipmap.f,"帮助中心"));
        Mes.add(new MeBean(R.mipmap.g,"意见反馈"));

        Rec_MeAdapter adapter = new Rec_MeAdapter(Mes, getActivity());
        recMe.setAdapter(adapter);
    }

    private void initView(View view) {
        ivMeTouxiang = (ImageView) view.findViewById(R.id.iv_me_touxiang);
        tvMeName = (TextView) view.findViewById(R.id.tv_me_name);
        ivJiantou = (ImageView) view.findViewById(R.id.iv_jiantou);
        recMe = (RecyclerView) view.findViewById(R.id.rec_me);

        recMe.setLayoutManager(new GridLayoutManager(getActivity(),3));

        tvMeName.setText("D");
        Glide.with(getActivity()).load(R.mipmap.aa).apply(new RequestOptions().circleCrop()).into(ivMeTouxiang);
    }
}
