package com.prayxiang.support.recyclerview.tools;

import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.prayxiang.support.recyclerview.ViewBinder;
import com.prayxiang.support.recyclerview.ViewHolder;


public class SpaceViewBinder extends ViewBinder<Space, ViewHolder> {
    private int spaceHeight = 10;

    public SpaceViewBinder() {
    }

    public SpaceViewBinder(int spaceHeight) {
        this.spaceHeight = spaceHeight;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        android.widget.Space space = new  android.widget.Space(parent.getContext());
        space.setMinimumHeight((int) TypedValue.applyDimension(1, this.spaceHeight, parent.getContext().getResources().getDisplayMetrics()));
        return new ViewHolder(space);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Space item) {
        if (item.space != spaceHeight) {
            android.support.v4.widget.Space space = (android.support.v4.widget.Space) holder.itemView;
            space.setMinimumHeight(holder.dp2px(item.space));
        }

    }
}
