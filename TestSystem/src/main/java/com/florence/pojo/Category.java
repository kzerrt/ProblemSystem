package com.florence.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther:Florence
 * @date:2022/07/25/16:34
 */
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
}
