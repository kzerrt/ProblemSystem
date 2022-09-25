package com.florence.Dto;

import com.florence.pojo.Problem;
import lombok.Data;

import java.util.List;

/**
 * @author Florence
 * TODO: 2022/09/13
 */

@Data
public class TestManger {

    private List<Problem> list;

    private Integer total;
}
