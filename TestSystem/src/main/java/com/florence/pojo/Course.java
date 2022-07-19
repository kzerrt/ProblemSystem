package com.florence.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther:Florence
 * @date:2022/07/19/17:10
 */
@Data
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Integer status;
}
