package com.tamic.mvp.sample.base.api;


import java.util.Map;

/**
 * Created by Tamic on 2017-12-28.
 */

public abstract class Api<T> extends ApiInit {

    public abstract T getData(Map maps);
}
