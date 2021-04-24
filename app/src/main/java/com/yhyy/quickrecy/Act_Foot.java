package com.yhyy.quickrecy;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yhyy.quickrecy.adapter.FootAdapter;
import com.yhyy.quickrecy.adapter.HFAdapter;
import com.yhyy.quickrecy.base.VH;
import com.yhyy.quickrecy.base.VHFoot;
import com.yhyy.quickrecy.base.VHHead;
import com.yhyy.quickrecy.inter.OnItemClickListener;
import com.yhyy.quickrecy.inter.OnLongClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Act_Foot extends BaseActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    List<String> stringList = new ArrayList<>();

    FootAdapter<String> footAdapter;

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
        footAdapter = new FootAdapter<String>(stringList) {
            @Override
            public int getLayoutId(int viewType) {
                if (viewType == FootAdapter.BODY) {
                    return R.layout.recy_content;
                } else if (viewType == FootAdapter.FOOT) {
                    return R.layout.include_control_foot;
                }
                return viewType;
            }

            @Override
            public void convert1(VH holder, String data, int position) {
                TextView tv = holder.getView(R.id.tv_item_name);
                tv.setText(data);
            }

            @Override
            public void convert2(VHFoot holder) {
                ImageView imageView = holder.getView(R.id.iv_foot);
                TextView textView = holder.getView(R.id.tv_foot);
                textView.setText("尾部");
            }
        };
        recyclerview.setAdapter(footAdapter);
        footAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Integer integer) {
                Toast.makeText(context, "" + integer, Toast.LENGTH_SHORT).show();
            }
        });
        footAdapter.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public void OnLongClick(View view, Integer integer) {
                Toast.makeText(context, "" + integer, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initToolBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void initData() {
        stringList.clear();
        for (int i = 0; i < 20; i++) {
            String a = "123";
            String b = "123456";
            String c = "123456789";
            if (i % 3 == 0) {
                stringList.add(a);
            } else if (i % 3 == 1) {
                stringList.add(b);
            } else if (i % 3 == 2) {
                stringList.add(c);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}