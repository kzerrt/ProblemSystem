package com.florence.dao;

import com.florence.pojo.Category;
import com.florence.pojo.Problem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/25/15:55
 */
@Mapper
public interface TestMapper {
    List<Problem> getPage(Integer page, Integer pageSize, String name);
    Integer getTotal(String name);
    void deleteByIds(Integer[] ids);
    @Select("select * from category")
    List<Category> getCategory();

    @Insert("insert into problem value(null,#{name},#{desc},#{grade},#{type},null,#{teaId});")
    void addProblem(Problem problem);

    @Select("select * from problem where id = #{id};")
    Problem queryById(Integer id);


    void updateProblem(Problem problem);
}
