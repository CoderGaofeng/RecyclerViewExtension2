package com.prayxiang.support.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by prayxiang on 2017/10/17.
 *
 * @description TODO
 */
@SuppressWarnings("all")
public class ViewBinder<T, V extends ViewHolder> {

   RecyclerView.Adapter adapter;

    public V onCreateViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return null;
    }

    public void onBindViewHolder(V holder, List<Object> payloads) {

    }

    public void onViewDetachedFromWindow(V viewHolder) {

    }

    public void onViewAttachedToWindow(V viewHolder) {
    }
}
