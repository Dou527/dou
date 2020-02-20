package com.example.work;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.moni.R;
import com.example.work.model.bean.Sort_TabBean;

import java.util.ArrayList;

public class GoodsDescActivity extends AppCompatActivity {

    private TextView mTv123;
    private Toolbar mTool;
    private TableLayout mTabDesc;
    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_desc);
        initView();


    }

    private void initView() {
        ArrayList<Sort_TabBean.DataBean.CategoryListBean> list = (ArrayList<Sort_TabBean.DataBean.CategoryListBean>) getIntent().getSerializableExtra("data");
        int posi = getIntent().getIntExtra("posi", -1);
        mTool = (Toolbar) findViewById(R.id.tool);
        setTitle("");
        setSupportActionBar(mTool);
        mTabDesc = (TableLayout) findViewById(R.id.tab_desc);
        mVp = (ViewPager) findViewById(R.id.vp);
    }
}
