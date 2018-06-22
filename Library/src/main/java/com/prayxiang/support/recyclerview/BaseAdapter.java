package com.prayxiang.support.recyclerview;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

public class BaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> {


    private static ErrorViewBinder defaultViewBinder = new ErrorViewBinder();
    private LayoutInflater inflater;


    private List<T> items = Collections.emptyList();

    public void setItems(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }

    protected TypeProvider provider;

    public BaseAdapter(TypeProvider provider) {
        this.provider = provider;
    }

    public TypeProvider getProvider() {
        return provider;
    }

    @NonNull
    @Override
    @CallSuper
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        ViewBinder binder = provider.getViewBinder(viewType);
        if (binder == null) {
            binder = defaultViewBinder;
        }
        assert inflater != null;
        return binder.onCreateViewHolder(inflater, parent);
    }


    @Override
    public final void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        throw new IllegalArgumentException("just overridden to make final.");
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        ViewBinder binder = provider.getViewBinder(holder.getItemViewType());
        if (binder == null) {
            binder = defaultViewBinder;
        }
        holder.setItem(getItem(position));
        binder.onBindViewHolder(holder, payloads);
    }


    @SuppressWarnings("unchecked")
    @Override
    public void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewBinder binder = provider.getViewBinder(holder.getItemViewType());
        if (binder == null) {
            binder = defaultViewBinder;
        }
        binder.adapter = this;
        binder.onViewAttachedToWindow(holder);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        ViewBinder binder = provider.getViewBinder(holder.getItemViewType());
        if (binder == null) {
            binder = defaultViewBinder;
        }
        binder.onViewDetachedFromWindow(holder);
    }

    @SuppressWarnings("unchecked")
    @Override
    public int getItemViewType(int position) {
        return provider.getItemViewType(getItem(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public Object getItem(int position) {
        return items.get(position);
    }
}
