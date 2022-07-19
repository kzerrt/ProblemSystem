package com.florence.Service;

import com.florence.Dto.StudentManger;
import com.florence.pojo.Students;
import com.florence.pojo.Teacher;

/**
 * @auther:Florence
 * @date:2022/07/18/10:00
 */
public interface StudentService {

    StudentManger getPage(Integer page, Integer pageSize, String name);

    Students queryStudentById(Integer id);

    void updateStudent(Students student);

    void addStudent(Students student);


    void deleteByIds(Integer[] ids);

    void status(Integer status,Integer[] ids);
}
