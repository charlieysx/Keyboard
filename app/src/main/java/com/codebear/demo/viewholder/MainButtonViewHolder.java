package com.codebear.demo.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.codebear.demo.R;

/**
 * description:
 * <p>
 * Created by CodeBear on 2017/7/29.
 */

public class MainButtonViewHolder extends RecyclerView.ViewHolder {

    public TextView tvButton;

    public MainButtonViewHolder(View itemView) {
        super(itemView);
        tvButton = (TextView) itemView.findViewById(R.id.tv_button);
    }
}
