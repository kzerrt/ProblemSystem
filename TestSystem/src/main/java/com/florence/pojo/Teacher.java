package com.florence.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther:Florence
 * @date:2022/07/17/17:30
 */
@Data
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Integer sex;
    private Integer birthday;
    private Integer inTime;
    private Integer countId;
    private Integer status;

}
