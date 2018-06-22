package com.prayxiang.support.recyclerview;

import android.support.v7.widget.RecyclerView;

public  class ListChangeCallback implements ListUpdateCallback {
        RecyclerView.Adapter adapter;

        public ListChangeCallback(RecyclerView.Adapter adapter) {
            this.adapter = adapter;
        }

        @Override
        public void onInserted(int position, int count) {
            if (adapter != null) {
                adapter.notifyItemRangeInserted(position, count);
            }
        }

        @Override
        public void onRemoved(int position, int count) {
            if (adapter != null) {
                adapter.notifyItemRangeRemoved(position,count);
            }
        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {
            if (adapter != null) {
                adapter.notifyItemMoved(fromPosition,toPosition);
            }
        }

        @Override
        public void onChanged(int position, int count, Object payload) {
            if (adapter != null) {
                adapter.notifyItemRangeChanged(position, count, payload);
            }
        }

        @Override
        public void onChanged() {
            if(adapter!=null){
                adapter.notifyDataSetChanged();
            }
        }
    }