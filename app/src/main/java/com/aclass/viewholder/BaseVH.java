package com.aclass.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.aclass.ViewType;

/**
 * Created by huzehao666 on 2017/11/25.
 */

abstract public class BaseVH extends RecyclerView.ViewHolder implements ViewType {
    public BaseVH(View itemView) {
        super(itemView);
    }
}
