package com.tamic.mvp.sample.bisiness.m;


import com.tamic.mvp.sample.base.m.data.BaseModel;
import com.tamic.mvp.sample.bisiness.UserBean;
import com.tamic.mvp.sample.bisiness.api.LoginApi;

import java.util.Map;

import retrofit2.Call;

/**
 * Created by Tamic on 2017-12-28.
 */

public class LoginModel extends BaseModel<LoginApi, UserBean> {


    public LoginModel() {
    }

    @Override
    public LoginApi getApi() {
        return new LoginApi<>();
    }

    @Override
    public UserBean getBean(Map maps) {
        //return (LoginBean) getApi().getData(var);
        return null;
    }

    public Call<UserBean> getFlowable(Map maps) {
        return getApi().getData(maps);
    }
}
