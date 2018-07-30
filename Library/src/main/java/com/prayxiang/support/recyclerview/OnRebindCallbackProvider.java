package com.prayxiang.support.recyclerview;

import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;

public interface OnRebindCallbackProvider<T extends ViewDataBinding> {
    OnRebindCallback<T> provider();
}
