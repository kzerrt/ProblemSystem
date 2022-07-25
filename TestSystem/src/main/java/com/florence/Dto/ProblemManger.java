package com.florence.Dto;

import com.florence.pojo.Problem;
import lombok.Data;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/25/16:01
 */
@Data
public class ProblemManger {

    private List<Problem> list;
    private Integer total;
}
