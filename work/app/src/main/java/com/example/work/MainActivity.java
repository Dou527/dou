package com.example.work;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.moni.R;
import com.example.work.Utils.ShowAndHindUtils;
import com.example.work.fragment.SortFragment;
import com.example.work.fragment.HomeFragment;
import com.example.work.fragment.MeFragment;
import com.example.work.fragment.ShopingFragment;
import com.example.work.fragment.TopicFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar mTool;
    private RadioButton mTvShouye;
    private RadioButton mTvZhuanti;
    private RadioButton mTvFenlei;
    private RadioButton mTvGouwuche;
    private RadioButton mTvWode;
    private TextView mTvToolbar;
    private HomeFragment homeFragment;
    private TopicFragment zhuanTiFragment;
    private SortFragment fenLeiFragment;
    private ShopingFragment shoppingFragment;
    private MeFragment meFragment;
    private Fragment old;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        zhuanTiFragment = new TopicFragment();
        fenLeiFragment = new SortFragment();
        shoppingFragment = new ShopingFragment();
        meFragment = new MeFragment();
        old = homeFragment;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fl,homeFragment)
                .add(R.id.fl,zhuanTiFragment)
                .add(R.id.fl,fenLeiFragment)
                .add(R.id.fl,shoppingFragment)
                .add(R.id.fl,meFragment)
                .show(old)
                .hide(fenLeiFragment)
                .hide(shoppingFragment)
                .hide(zhuanTiFragment)
                .hide(meFragment)
                .commit();
        mTvShouye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowAndHindUtils.showhind(MainActivity.this,homeFragment,old);
                mTvToolbar.setText("仿网易严选");
                mTool.setBackgroundResource(R.drawable.white);
                mTvToolbar.setTextColor(Color.BLACK);
                old = homeFragment;
            }
        });
        mTvZhuanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowAndHindUtils.showhind(MainActivity.this,zhuanTiFragment,old);
                mTool.setBackgroundResource(R.drawable.white);
                mTvToolbar.setText("仿网易严选");
                mTvToolbar.setTextColor(Color.BLACK);
                old = zhuanTiFragment;
            }
        });
        mTvFenlei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowAndHindUtils.showhind(MainActivity.this,fenLeiFragment,old);
                mTvToolbar.setText("仿网易严选");
                mTvToolbar.setTextColor(Color.BLACK);
                mTool.setBackgroundResource(R.drawable.white);
                old = fenLeiFragment;
            }
        });
        mTvGouwuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowAndHindUtils.showhind(MainActivity.this,shoppingFragment,old);
                mTvToolbar.setText("仿网易严选");
                mTvToolbar.setTextColor(Color.BLACK);
                mTool.setBackgroundResource(R.drawable.white);
                old = shoppingFragment;
            }
        });
        mTvWode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowAndHindUtils.showhind(MainActivity.this,meFragment,old);
                mTvToolbar.setText("我的");
                mTvToolbar.setTextColor(Color.WHITE);
                mTool.setBackgroundResource(R.drawable.bulake);
                old = meFragment;
            }
        });
    }

    private void initView() {
        mTool = (Toolbar) findViewById(R.id.tool);
        setTitle("");
        setSupportActionBar(mTool);
        mTvShouye = (RadioButton) findViewById(R.id.tv_shouye);
        mTvZhuanti = (RadioButton) findViewById(R.id.tv_zhuanti);
        mTvFenlei = (RadioButton) findViewById(R.id.tv_fenlei);
        mTvGouwuche = (RadioButton) findViewById(R.id.tv_gouwuche);
        mTvWode = (RadioButton) findViewById(R.id.tv_wode);
        mTvToolbar = (TextView) findViewById(R.id.tv_toolbar);
    }
}
