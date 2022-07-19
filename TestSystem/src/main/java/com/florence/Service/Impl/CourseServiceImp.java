package com.florence.Service.Impl;

import com.florence.Dto.CourseManger;
import com.florence.Service.CourseService;
import com.florence.dao.CourseMapper;
import com.florence.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/19/17:25
 */
@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public CourseManger getPage(Integer page, Integer pageSize, String name) {
        List<Course> list = courseMapper.getPage(page, pageSize, name);
        if(name != null){
            name = '%' + name +'%';
        }
        Integer total = courseMapper.getTotal(name);

        return new CourseManger(list,total);
    }

    @Override
    public void addCourse(String name) {
        courseMapper.addCourse(name);
    }

    @Override
    public void updateInfo(Course course) {
        courseMapper.updateInfo(course);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        courseMapper.deleteByIds(ids);
    }

    @Override
    public void status(Integer status, Integer[] ids) {
        courseMapper.status(status,ids);
    }


}
