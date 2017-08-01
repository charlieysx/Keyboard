package com.codebear.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codebear.demo.bean.MainButton;
import com.codebear.demo.viewholder.MainButtonViewHolder;
import com.codebear.demo.R;
import com.codebear.demo.base.BaseAdapter;

/**
 * description:
 * <p>
 * Created by CodeBear on 2017/7/29.
 */

public class MainButtonAdapter extends BaseAdapter<MainButton, MainButtonViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener onItemClickListener;

    private Context mContext;

    public MainButtonAdapter(Context context) {
        mContext = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MainButtonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainButtonViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_main_button, parent, false));
    }

    @Override
    public void onBindViewHolder(final MainButtonViewHolder holder, int position) {
        holder.tvButton.setText(get(position).getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(getPosition(holder));
                }
            }
        });
    }
}
