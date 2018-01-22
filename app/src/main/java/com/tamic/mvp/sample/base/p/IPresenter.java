package com.tamic.mvp.sample.base.p;


import com.tamic.mvp.sample.base.v.IBaseView;
/**
 * This specifies the contract between the view and the presenter.
 * Created by Tamic on 2018-01-04.
 */
public interface IPresenter<V extends IBaseView> {

    void start();

    void attachView(V view);

    void detachView(boolean retainInstance);
}
