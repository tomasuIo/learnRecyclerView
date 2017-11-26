package com.aclass.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.aclass.R;
/**
 * Created by huzehao666 on 2017/11/25.
 */

public class TextVH extends BaseVH{
    public  TextView textView;
    public TextVH(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.next_text);
    }
    @Override
    public int getViewType() {
        return TextType;
    }
}
