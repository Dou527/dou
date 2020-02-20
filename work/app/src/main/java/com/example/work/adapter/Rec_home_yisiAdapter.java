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

public class Rec_home_yisiAdapter extends RecyclerView.Adapter<Rec_home_yisiAdapter.Vh> {
    private List<HomeBean.DataBean.NewGoodsListBean> list;
    private Context con;

    public Rec_home_yisiAdapter(List<HomeBean.DataBean.NewGoodsListBean> list, Context con) {
        this.list = list;
        this.con = con;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(con, R.layout.item_home_yisi, null);
        return new Vh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.price.setText(list.get(position).getRetail_price());
        Glide.with(con).load(list.get(position).getList_pic_url()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Vh extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        public Vh(@NonNull View itemView) {
            super(itemView);
            img =  itemView.findViewById(R.id.iv_item_home_yisi);
            name =  itemView.findViewById(R.id.tv_item_home_yisiname);
            price =  itemView.findViewById(R.id.tv_item_home_yisiprice);
        }
    }
}
