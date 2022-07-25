package com.florence.dao;

import com.florence.pojo.Cal;
import com.florence.pojo.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/19/17:14
 */
@Mapper
public interface CourseMapper {

    List<Course> getPage(Integer page,Integer pageSize,String name);

    Integer getTotal(String name);

    @Insert("insert into course value(null,#{name},null);")
    void addCourse(String name);

    @Update("update course set name = #{name} where id = #{id};")
    void updateInfo(Course course);

    void deleteByIds(Integer[] ids);

    void status(Integer status,Integer[] ids);

    @Insert("insert into tea_cou_clatable value (#{userId},#{courseId},0);")
    void addMyCourse(Integer userId,Integer courseId);

    @Insert("insert into tea_cou_clatable value (#{userId},#{courseId},#{classId});")
    void addClass(Integer courseId,Integer classId,Integer userId);
}
