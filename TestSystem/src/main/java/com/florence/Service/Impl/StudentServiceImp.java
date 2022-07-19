package com.florence.Service.Impl;

import com.florence.Dto.StudentManger;
import com.florence.Service.StudentService;
import com.florence.dao.StudentMapper;
import com.florence.pojo.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/18/10:01
 */
@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentManger getPage(Integer page, Integer pageSize, String name) {
        List<Students> list = studentMapper.getPage(page, pageSize, name);
        Integer total = studentMapper.getTotal(name);
        StudentManger studentManger = new StudentManger();
        studentManger.setTotal(total);
        studentManger.setList(list);
        return studentManger;
    }

    @Override
    public Students queryStudentById(Integer id) {
        return studentMapper.queryStudentById(id);
    }

    @Override
    public void updateStudent(Students student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public void addStudent(Students student) {
        studentMapper.addStudent(student);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        studentMapper.deleteByIds(ids);
    }

    @Override
    public void status(Integer status, Integer[] ids) {
        studentMapper.status(status,ids);
    }

}
