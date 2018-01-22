package com.tamic.mvp.sample.bisiness.api;


import com.tamic.mvp.sample.base.api.Api;
import com.tamic.mvp.sample.bisiness.UserBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/**
 * Created by Tamic on 2017-12-28.
 */

public class LoginApi<T> extends Api {

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[] {
            "foo@example.com:hello", "bar@example.com:world"
    };

    @Override
    public Call<UserBean> getData(Map maps) {
        return create(LoginApiService.class).login(maps);

    }


    public interface LoginApiService {

        /**
         * http://ip.taobao.com/service/getIpInfo.php?ip=21.22.11.33
         */
        @GET("service/getIpInfo.php")
        @Headers( {"Accept: application/json"})
        Call<UserBean> login(
                @QueryMap Map<String, String> maps);
    }
}
