package com.yhyy.quickrecy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yhyy.quickrecy.adapter.QuickAdapter;
import com.yhyy.quickrecy.base.VH;
import com.yhyy.quickrecy.config.Contracts;
import com.yhyy.quickrecy.inter.OnItemClickListener;
import com.yhyy.quickrecy.inter.OnLongClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    QuickAdapter<String> quickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initToolBar();
        initListener();
    }

    private void initListener() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        recyclerview.setLayoutManager(linearLayoutManager);
        quickAdapter = new QuickAdapter<String>(Contracts.typeList) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.recy_content;
            }

            @Override
            public void convert(VH holder, String data, int position) {
                TextView tv = holder.getView(R.id.tv_item_name);
                tv.setText(Contracts.typeList.get(position));
            }
        };
        recyclerview.setAdapter(quickAdapter);
        quickAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Integer integer) {
                switch (integer) {
                    case 0:
                        startActivity(new Intent(context, Act_Head.class));
                        break;
                    case 1:
                        startActivity(new Intent(context, Act_Foot.class));
                        break;
                    case 2:
                        startActivity(new Intent(context, Act_HF.class));
                        break;
                }
            }
        });
        quickAdapter.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public void OnLongClick(View view, Integer integer) {
                Toast.makeText(context, "" + integer, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initToolBar() {
    }

    private void initData() {

    }
}