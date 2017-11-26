package com.aclass.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aclass.R;
import com.aclass.beans.ImgAndTxtEntity;
import com.aclass.ViewType;
import com.aclass.viewholder.BaseVH;
import com.aclass.viewholder.ImageAndTextVH;

import java.util.List;

/**
 * Created by huzehao666 on 2017/11/25.
 */

public class ImgAndTxtAdapterDelegate  implements ViewType {

    public boolean isForViewType(List<Object> items, int position) {
        return items.get(position) instanceof ImgAndTxtEntity;
    }

    public BaseVH onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_text_view,parent,false);
        return new ImageAndTextVH(view);
    }
    public void bindViewHolder(List<Object> items, int position, BaseVH holder) {
        ImgAndTxtEntity entity = (ImgAndTxtEntity) items.get(position);
        ((ImageAndTextVH) holder).textView.setText(entity.text);
        ((ImageAndTextVH) holder).imageView.setImageResource(entity.imageId);
    }

    @Override
    public int getViewType() {
        return ImageAndTextType;
    }
}
