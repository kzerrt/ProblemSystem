package com.florence.Dto;

import com.florence.pojo.Students;
import lombok.Data;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/19/19:07
 */
@Data
public class StudentManger {
    private List<Students> list;
    private Integer total;
}
