package com.prayxiang.support.recyclerview.tools;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.prayxiang.support.recyclerview.ViewBinder;
import com.prayxiang.support.recyclerview.ViewHolder;

import java.util.List;

/**
 * Created by xianggaofeng on 2018/3/1.
 */

public class SimpleViewBinder<T> extends ViewBinder<T, ViewHolder> {
    private int mLayoutId;

    public SimpleViewBinder(int layoutId) {
        mLayoutId = layoutId;
    }


    @Override
    public ViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent) {
        ViewHolder holder = new ViewHolder(inflater.inflate(mLayoutId, parent, false));
        onViewCreated(holder);
        return holder;
    }

    public void onViewCreated(ViewHolder holder) {
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, List payloads) {
        bindItem(holder, holder.<T>getItem());
    }


    public void bindItem(ViewHolder holder, Object item) {

    }
}
