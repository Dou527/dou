package com.example.work.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moni.R;
import com.example.work.model.bean.HomeBean;

import java.util.List;

public class Rec_home_zhigongAdapter extends RecyclerView.Adapter<Rec_home_zhigongAdapter.Vh> {
    private List<HomeBean.DataBean.BrandListBean> list;
    private Context con;

    public Rec_home_zhigongAdapter(List<HomeBean.DataBean.BrandListBean> brandList, Context con) {
        this.list = brandList;
        this.con = con;
    }

    @NonNull
    @Override
    public Rec_home_zhigongAdapter.Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(con, R.layout.item_home_zhigong, null);
        return new Vh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Rec_home_zhigongAdapter.Vh holder, int position) {
        holder.tv.setText(list.get(position).getName());
        Glide.with(con).load(list.get(position).getNew_pic_url()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    //new_pic_url
    public class Vh extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;
        public Vh(@NonNull View itemView) {
            super(itemView);
           img =  itemView.findViewById(R.id.iv_item_home);
            tv =  itemView.findViewById(R.id.tv_item_home);
        }
    }
}
