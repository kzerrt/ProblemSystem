package com.florence.Service;

import com.florence.Dto.ClassManger;
import com.florence.pojo.Cal;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/14/16:35
 */
public interface ClassService {

    List<Cal> getClasses();

    ClassManger getPage(Integer page, Integer pageSize, String name);

    void addClass(Cal cal);

    Cal queryClass(Integer id);

    void updateInfo(Cal cal);

    void deleteByIds(Integer[] ids);

    void status(Integer status,Integer[] ids);

    Integer queryClassNumberById(Integer id);
}
