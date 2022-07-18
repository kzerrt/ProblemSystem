package com.florence.Service;

import com.florence.pojo.Count;

/**
 * @auther:Florence
 * @date:2022/07/13/9:02
 */
public interface LoginService {

    /**
     * 通过用户账号获取全部账号信息
     * */
    Count login(Integer username);

    Count createCount(Integer username,Integer type);
}
