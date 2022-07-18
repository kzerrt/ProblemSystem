package com.florence.Dto;

import com.florence.pojo.Cal;
import lombok.Data;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/14/16:57
 */
@Data
public class ClassManger {

    private List<Cal> list;
    private Integer total;

}
