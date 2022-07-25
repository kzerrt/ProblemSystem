package com.florence.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther:Florence
 * @date:2022/07/25/15:52
 */
@Data
public class Problem implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String desc;
    private Integer grade;
    private String type;
    private Integer teaId;
}
