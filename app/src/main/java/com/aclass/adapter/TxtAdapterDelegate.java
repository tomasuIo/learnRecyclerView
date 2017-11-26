package com.aclass.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aclass.R;
import com.aclass.beans.TextEntity;
import com.aclass.viewholder.BaseVH;
import com.aclass.viewholder.TextVH;

import java.util.List;
import com.aclass.ViewType;
/**
 * Created by huzehao666 on 2017/11/25.
 */

public class TxtAdapterDelegate implements ViewType {

    public boolean isForViewType(List<Object> items, int position) {
        return items.get(position) instanceof TextEntity;
    }
    public BaseVH onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view,parent,false);
        return new TextVH(view);
    }
    public void bindViewHolder(List<Object> items, int position, BaseVH holder) {
        TextEntity entity = (TextEntity)items.get(position);
        ((TextVH)holder).textView.setText(entity.text);
    }

    @Override
    public int getViewType() {
        return TextType;
    }
}
