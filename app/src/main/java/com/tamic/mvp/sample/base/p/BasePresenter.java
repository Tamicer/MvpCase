package com.tamic.mvp.sample.base.p;


import com.tamic.mvp.sample.base.v.IBaseView;

import java.lang.ref.WeakReference;

/**
 * Created by Tamic on 2018-01-08.
 */

public abstract class BasePresenter<V extends IBaseView> implements IPresenter<V> {

    private WeakReference<V> viewRef;


    @Override
    public void attachView(V view) {
        viewRef = new WeakReference<V>(view);
    }


    protected V getView() {
        return viewRef == null ? null : viewRef.get();
    }


    protected boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    @Override
    public void detachView(boolean retainInstance) {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}
