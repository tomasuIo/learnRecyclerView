package com.aclass.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aclass.R;
import com.aclass.beans.ImgAndTxtEntity;
import com.aclass.beans.TextEntity;
import com.aclass.viewholder.BaseVH;
import com.aclass.viewholder.ImageAndTextVH;
import com.aclass.viewholder.TextVH;

import java.util.List;

/**
 * Created by huzehao666 on 2017/11/16.
 */

public class TermAdapter extends RecyclerView.Adapter<BaseVH> {
    private final int fisrt_5_item = 0;
    private final int next_5_item = 1;
    private List<Object> terms;
    private OnItemClickListener mOnItemClickListener = null;

    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
    ImgAndTxtAdapterDelegate imgAndTxtAdapterDelegate = new ImgAndTxtAdapterDelegate();
    TxtAdapterDelegate txtAdapterDelegate = new TxtAdapterDelegate();
    @Override
    public int getItemViewType(int position) {

        if(imgAndTxtAdapterDelegate.isForViewType(terms,position)) {
            return imgAndTxtAdapterDelegate.getViewType();

        }
        else if(txtAdapterDelegate.isForViewType(terms,position)) {
            return   txtAdapterDelegate.getViewType();
        }
        return -1;
    }

    public TermAdapter(List<Object> data) {
        terms = data;
    }

    @Override
    public BaseVH onCreateViewHolder(final ViewGroup parent, int viewType) {
        if(txtAdapterDelegate.getViewType() == viewType)
            return txtAdapterDelegate.onCreateViewHolder(parent);
        else
            return imgAndTxtAdapterDelegate.onCreateViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseVH holder, final int position) {
        int viewType = holder.getViewType();
        if(imgAndTxtAdapterDelegate.getViewType() == viewType) {
            imgAndTxtAdapterDelegate.bindViewHolder(terms, position, holder);
        }
        else if(txtAdapterDelegate.getViewType() == viewType){
            txtAdapterDelegate.bindViewHolder(terms, position, holder);
        }
        if(mOnItemClickListener!=null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return terms.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}