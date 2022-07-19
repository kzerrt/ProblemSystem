package com.florence.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther:Florence
 * @date:2022/07/17/17:30
 */
@Data
public class Students implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Integer sex;
    private Integer birthday;
    private Integer code;
    private Integer inTime;
    private Integer countId;
    private String cla;
    private Integer status;

}
