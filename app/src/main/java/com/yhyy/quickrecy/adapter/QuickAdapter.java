package com.yhyy.quickrecy.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.yhyy.quickrecy.base.VH;
import com.yhyy.quickrecy.inter.OnItemClickListener;
import com.yhyy.quickrecy.inter.OnLongClickListener;

import java.util.List;

public abstract class QuickAdapter<T> extends RecyclerView.Adapter<VH> {
    public OnItemClickListener onItemClickListener;
    public OnLongClickListener onLongClickListener;
    private List<T> datas;

    public QuickAdapter(List<T> datas) {
        this.datas = datas;
    }

    public abstract int getLayoutId(int viewType);

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return VH.get(parent, getLayoutId(viewType));
    }

    @Override
    public void onBindViewHolder(VH vh, int position) {
        convert(vh, datas.get(position), position);
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnItemClick(vh.itemView, position);
            }
        });
        vh.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onLongClickListener.OnLongClick(vh.itemView, position);
                return false;
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener itemListener) {
        this.onItemClickListener = itemListener;
    }

    public void setOnLongClickListener(OnLongClickListener longListener) {
        this.onLongClickListener = longListener;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public abstract void convert(VH holder, T data, int position);
}
