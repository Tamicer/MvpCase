package com.tamic.mvp.sample.base.m.data;


import java.util.Map;

/**
 * Created by Tamic on 2017-12-28.
 */

public abstract class BaseModel<T, E> {

    abstract public   T getApi();

    abstract public E getBean(Map maps);
}
