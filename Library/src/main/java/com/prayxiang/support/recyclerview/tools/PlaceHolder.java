package com.prayxiang.support.recyclerview.tools;

public class PlaceHolder<T> implements Cell {
    private int type;
    private T item;

    public PlaceHolder(int type, T item) {
        this.type = type;
        this.item = item;
    }


    public T getItem() {
        return (T) item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public int getItemViewType() {
        return type;
    }
}
