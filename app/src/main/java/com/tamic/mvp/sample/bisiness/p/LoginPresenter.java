package com.tamic.mvp.sample.bisiness.p;


import com.tamic.mvp.sample.base.api.CallBack;
import com.tamic.mvp.sample.base.p.BasePresenter;
import com.tamic.mvp.sample.bisiness.LoginContract;
import com.tamic.mvp.sample.bisiness.UserBean;
import com.tamic.mvp.sample.bisiness.m.LoginModel;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Tamic on 2018-01-03.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> {

    private LoginModel model;

    public LoginPresenter() {
        model = new LoginModel();
    }

    public UserBean login(Map var) throws IOException {
        getView().showLoading();
        if (!isViewAttached()) {
            return null;
        }
        return model.getFlowable(var).execute().body();
    }

    public void login(final CallBack callBack, Map var) {
        if (!isViewAttached()) {
            return;
        }
        getView().showLoading();
        model.getFlowable(var).enqueue(new Callback<UserBean>() {

            @Override
            public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                getView().dismissLoading();
                callBack.onSuccess(response.code(), response.message(), response.body());
                callBack.onFinal();
            }

            @Override
            public void onFailure(Call<UserBean> call, Throwable t) {
                getView().dismissLoading();
                callBack.onFailure(-100, t.getMessage());
                callBack.onFinal();
            }
        });


    }


    @Override
    public void start() {

    }
}
