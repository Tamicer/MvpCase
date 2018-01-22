package com.tamic.mvp.sample.base.v;


import com.tamic.mvp.sample.base.p.IPresenter;
/**
 * This specifies the contract between the view and the presenter.
 * Created by Tamic on 2018-01-04.
 */
public interface IBaseView<T extends IPresenter> {

    void setPresenter(T presenter);
}