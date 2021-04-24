package com.yhyy.quickrecy.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.yhyy.quickrecy.base.VH;
import com.yhyy.quickrecy.base.VHFoot;
import com.yhyy.quickrecy.base.VHHead;
import com.yhyy.quickrecy.inter.OnItemClickListener;
import com.yhyy.quickrecy.inter.OnLongClickListener;

import java.util.List;

public abstract class HFAdapter<T> extends RecyclerView.Adapter {
    public OnItemClickListener onItemClickListener;
    public OnLongClickListener onLongClickListener;
    private List<T> datas;
    public static final int HEAD = 0;
    public static final int BODY = 1;
    public static final int FOOT = 2;

    public HFAdapter(List<T> datas) {
        this.datas = datas;
    }

    public abstract int getLayoutId(int viewType);

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEAD:
                return VHHead.get(parent, getLayoutId(viewType));
            case BODY:
                return VH.get(parent, getLayoutId(viewType));
            case FOOT:
                return VHFoot.get(parent, getLayoutId(viewType));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof VHHead) {
            VHHead vhHead = (VHHead) viewHolder;
            convert1(vhHead);
        } else if (viewHolder instanceof VH) {
            VH vh = (VH) viewHolder;
            convert2(vh, datas.get(position - 1), position);
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
        } else if (viewHolder instanceof VHFoot) {
            VHFoot vhFoot = (VHFoot) viewHolder;
            convert3(vhFoot);
        }
    }

    public void setOnItemClickListener(OnItemClickListener itemListener) {
        this.onItemClickListener = itemListener;
    }

    public void setOnLongClickListener(OnLongClickListener longListener) {
        this.onLongClickListener = longListener;
    }

    @Override
    public int getItemCount() {
        return datas.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD;
        } else if (position == datas.size() + 1) {
            return FOOT;
        } else {
            return BODY;
        }
    }


    public abstract void convert1(VHHead holder);

    public abstract void convert2(VH holder, T data, int position);

    public abstract void convert3(VHFoot holder);
}
