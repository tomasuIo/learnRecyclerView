package com.aclass.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aclass.R;

/**
 * Created by huzehao666 on 2017/11/25.
 */

public class ImageAndTextVH extends BaseVH{
    public ImageView imageView;
    public TextView textView;
    public ImageAndTextVH(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.first_5_items_image);
        textView  =itemView.findViewById(R.id.first_5_items_text);
    }

    @Override
    public int getViewType() {
        return ImageAndTextType;
    }
}
