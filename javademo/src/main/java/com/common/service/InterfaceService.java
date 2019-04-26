package com.common.service;

public interface InterfaceService {

    //default默认实现
    default String getName() {
        return "tom";
    }

    //可以直接用接口名去调接口的静态方法
    static String getName2() {
        return "cat";
    }
}
