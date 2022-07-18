package com.florence.common;

/**
 * @auther:Florence
 * @date:2022/06/15/10:50
 *
 * 基于ThreadLocal封装工具类，用于保存和获取当前登录用户id
 */
public class BaseContext {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Integer id){
        threadLocal.set(id.longValue());
    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }

    public static void remove(){
        threadLocal.remove();
    }
}
