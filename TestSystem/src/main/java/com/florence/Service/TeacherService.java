package com.florence.Service;

import com.florence.Dto.TeacherManger;
import com.florence.pojo.Teacher;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/18/10:00
 */
public interface TeacherService {

    TeacherManger getPage(Integer page, Integer pageSize, String name);

    Teacher queryTeacherById(Integer id);

    void updateTeacher(Teacher teacher);

    void addTeacher(Teacher teacher);

    void deleteByIds(Integer[] ids);

    void status(Integer status,Integer[] ids);
}
