package com.tamic.mvp.sample.base.api;


import android.content.Context;
import android.text.TextUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tamic on 2017-12-28.
 */
public class ApiInit {


    private static final int DEFAULT_TIMEOUT = 20;
    private static BaseApiService apiService;
    private static OkHttpClient okHttpClient;
    public static String baseUrl = BaseApiService.BASE_URL;
    private static Context context;
    private static Retrofit retrofit;


    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    // .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(baseUrl);

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder()
                    .addNetworkInterceptor(
                            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);


    static public void initialize(Context appContext) {
        initApi(appContext, baseUrl);
        createBaseApi();
    }


    private static void initApi(Context appContext, String url) {
        context = appContext;
        if (TextUtils.isEmpty(url)) {
            url = baseUrl;
        }

        okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(
                        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(url)
                .build();

    }

    /**
     * create BaseApi  defalte ApiManager
     *
     * @return ApiManager.
     */
    private static BaseApiService createBaseApi() {
        return apiService = create(BaseApiService.class);
    }

    public BaseApiService getApiService() {
        if (apiService == null) {
            return createBaseApi();
        }
        return apiService;
    }

    /**
     * create you ApiService
     * Create an implementation of the API endpoints defined by the {@code service} interface.
     */
    public static <T> T create(final Class<T> service) {
        if (service == null) {
            throw new RuntimeException("Api service is null!");
        }
        return retrofit.create(service);
    }

}
