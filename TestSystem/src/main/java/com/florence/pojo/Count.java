package com.florence.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther:Florence
 * @date:2022/07/12/21:26
 */
@Data
public class Count implements Serializable {

    private static final long serialVersionUID = 1L;

    //账号id序列
    private Integer id;

    //账号名称
    private Integer username;

    //账号密码
    private String password;

    //账号主人类型
    private Integer type;

}
