package com.florence.dao;

import com.florence.pojo.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/18/9:52
 */
@Mapper
public interface TeacherMapper {

    List<Teacher> getPage(Integer page,Integer pageSize,String name);

    Integer getTotal(String name);

    @Select("select * from teacher where id = #{id}")
    Teacher queryTeacherById(Integer id);

    void addTeacher(Teacher teacher);


    void updateTeacher(Teacher teacher);

    void deleteByIds(Integer[] ids);

    void status(Integer status,Integer[] ids);
}
