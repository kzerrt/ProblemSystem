package com.florence.Service;

import com.florence.Dto.CourseManger;
import com.florence.pojo.Course;

/**
 * @auther:Florence
 * @date:2022/07/19/17:25
 */
public interface CourseService {

    CourseManger getPage(Integer page,Integer pageSize,String name);


    void addCourse(String name);


    void updateInfo(Course course);

    void deleteByIds(Integer[] ids);

    void status(Integer status,Integer[] ids);
}
