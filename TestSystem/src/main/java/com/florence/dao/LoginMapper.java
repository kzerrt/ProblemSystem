package com.florence.dao;

import com.florence.pojo.Count;
import com.florence.pojo.Students;
import com.florence.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @auther:Florence
 * @date:2022/07/12/11:53
 * 用户登录后端持久层
 */
@Mapper
public interface LoginMapper {

    @Select("select * from count where username = #{username};")
    Count login(Integer username);

    Count createCount(Integer username,Integer type);

    @Select("select * from teacher where count_id = #{countId};")
    Teacher getTeacher(Integer countId);

    @Select("select * from student where count_id = #{countId};")
    Students getStudent(Integer countId);
}
