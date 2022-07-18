package com.florence.Dto;

import com.florence.pojo.Teacher;
import lombok.Data;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/17/18:27
 */
@Data
public class TeacherManger {
    List<Teacher> list;
    Integer total;
}
