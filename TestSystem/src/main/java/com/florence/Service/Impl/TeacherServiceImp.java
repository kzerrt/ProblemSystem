package com.florence.Service.Impl;

import com.florence.Dto.TeacherManger;
import com.florence.Service.TeacherService;
import com.florence.dao.TeacherMapper;
import com.florence.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/18/10:01
 */
@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public TeacherManger getPage(Integer page, Integer pageSize, String name) {
        List<Teacher> list = teacherMapper.getPage(page, pageSize, name);
        Integer total = teacherMapper.getTotal(name);
        TeacherManger teacherManger = new TeacherManger();
        teacherManger.setTotal(total);
        teacherManger.setList(list);
        return teacherManger;
    }

    @Override
    public Teacher queryTeacherById(Integer id) {
        return teacherMapper.queryTeacherById(id);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherMapper.addTeacher(teacher);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        teacherMapper.deleteByIds(ids);
    }

    @Override
    public void status(Integer status, Integer[] ids) {
        teacherMapper.status(status,ids);
    }

}
