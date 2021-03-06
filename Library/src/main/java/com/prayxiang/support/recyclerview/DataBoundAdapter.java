package com.prayxiang.support.recyclerview;

import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.Collections;
import java.util.List;


public class DataBoundAdapter<T> extends BaseAdapter<T> implements OnRebindCallbackProvider<ViewDataBinding> {

    private RecyclerView recyclerView;
    static final Object DB_PAYLOAD = new Object();
    final OnRebindCallback mOnRebindCallback = new OnRebindCallback() {
        @Override
        public boolean onPreBind(ViewDataBinding binding) {
            if (recyclerView == null || recyclerView.isComputingLayout()) {
                return true;
            }
            int childAdapterPosition = recyclerView.getChildAdapterPosition(binding.getRoot());
            if (childAdapterPosition == RecyclerView.NO_POSITION) {
                return true;
            }
            notifyItemChanged(childAdapterPosition, DB_PAYLOAD);
            return false;
        }
    };

    private ClassTypeProvider provider;

    public DataBoundAdapter() {
        super(new ClassTypeProvider());
        this.provider = (ClassTypeProvider) super.provider;
    }


    public void display(List<T> list) {
        if (list == null) {
            list = Collections.emptyList();
        }

        setItems(list);
        notifyDataSetChanged();
    }


    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;

    }


    public DataBoundAdapter addViewBinder(Class cls, ViewBinder viewBinder) {
        provider.addViewBinder(cls, viewBinder);
        return this;
    }

    @Override
    public OnRebindCallback<ViewDataBinding> provider() {
        return mOnRebindCallback;
    }
}
