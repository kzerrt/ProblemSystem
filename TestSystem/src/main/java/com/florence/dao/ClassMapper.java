package com.florence.dao;

import com.florence.pojo.Cal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/14/16:35
 */
@Mapper
public interface ClassMapper {

    List<Cal> getPage(Integer page,Integer pageSize,String name);

    Integer getTotal(String name);

    @Insert("insert into class(id,name,number,status) value(#{id},#{name},#{number},null);")
    void addClass(Cal cal);

    @Select("select * from class where id = #{id};")
    Cal queryClass(Integer id);

    @Update("update class set name = #{name} where id = #{id};")
    void updateInfo(Cal cal);

    void deleteByIds(Integer[] ids);

    void status(Integer status,Integer[] ids);

    @Select("select number from class where id = #{id};")
    Integer queryNumberById(Integer id);

}
