package com.florence.dao;

import com.florence.pojo.Students;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/18/9:52
 */
@Mapper
public interface StudentMapper {

    List<Students> getPage(Integer page, Integer pageSize, String name);

    Integer getTotal(String name);

    @Select("select * from student where id = #{id}")
    Students queryStudentById(Integer id);

    void addStudent(Students student);


    void updateStudent(Students student);

    void deleteByIds(Integer[] ids);

    void status(Integer status,Integer[] ids);
}
