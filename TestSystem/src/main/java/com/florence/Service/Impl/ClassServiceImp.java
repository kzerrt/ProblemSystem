package com.florence.Service.Impl;

import com.florence.Dto.ClassManger;
import com.florence.Service.ClassService;
import com.florence.dao.ClassMapper;
import com.florence.pojo.Cal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/14/16:36
 */
@Service
public class ClassServiceImp implements ClassService {

    @Autowired
    private ClassMapper classMapper;


    @Override
    public ClassManger getPage(Integer page, Integer pageSize, String name) {
        List<Cal> page1 = classMapper.getPage(page, pageSize, name);
        Integer total = classMapper.getTotal(name);
        ClassManger classmanger = new ClassManger();
        classmanger.setList(page1);
        classmanger.setTotal(total);
        return classmanger;
    }

    @Override
    public void addClass(Cal cal) {
        classMapper.addClass(cal);
    }

    @Override
    public Cal queryClass(Integer id) {

        return classMapper.queryClass(id);
    }

    @Override
    public void updateInfo(Cal cal) {
        classMapper.updateInfo(cal);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        classMapper.deleteByIds(ids);
    }

    @Override
    public void status(Integer status, Integer[] ids) {
        classMapper.status(status,ids);
    }

    @Override
    public Integer queryClassNumberById(Integer id) {

        return classMapper.queryNumberById(id);
    }
}
