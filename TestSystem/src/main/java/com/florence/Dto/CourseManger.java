package com.florence.Dto;

import com.florence.pojo.Course;
import lombok.Data;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/19/17:26
 */
@Data
public class CourseManger {

    private List<Course> list;
    private Integer total;

    public CourseManger(List<Course> list, Integer total) {
        this.list = list;
        this.total = total;
    }
}
