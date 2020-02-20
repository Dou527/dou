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
import com.example.work.model.bean.Sort_TabBean;

import java.util.List;
public class Rec_sortAdapter extends RecyclerView.Adapter<Rec_sortAdapter.Vh>{
    private List<Sort_TabBean.DataBean.CategoryListBean> list;
    private Context con;

    public Rec_sortAdapter(List<Sort_TabBean.DataBean.CategoryListBean> list, Context con) {
        this.list = list;
        this.con = con;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(con, R.layout.item_sort, null);
        return new Vh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh holder, final int position) {
        holder.tv.setText(list.get(position).getName());
        Glide.with(con).load(list.get(position).getBanner_url()).into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.OnItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class Vh extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView img;
        public Vh(@NonNull View itemView) {
            super(itemView);
           img = itemView.findViewById(R.id.iv_item_fenlei);
           tv = itemView.findViewById(R.id.tv_item_fenlei);
        }
    }
    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public interface OnClick{
        void OnItemClick(int position);
    }
}
