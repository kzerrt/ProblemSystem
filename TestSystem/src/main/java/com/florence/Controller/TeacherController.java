package com.florence.Controller;

import com.florence.Dto.TeacherManger;
import com.florence.Service.LoginService;
import com.florence.Service.TeacherService;
import com.florence.common.R;
import com.florence.pojo.Count;
import com.florence.pojo.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther:Florence
 * @date:2022/07/18/10:02
 */
@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private LoginService loginService;

    @GetMapping("/page")
    public R<TeacherManger> getPage(Integer page,Integer pageSize,String name){

        if(name != null){
            name = '%' + name + '%';
        }
        TeacherManger list = teacherService.getPage(page - 1, pageSize, name);
        return R.success(list);
    }

    @GetMapping("/query/{id}")
    public R<Teacher> queryById(@PathVariable Integer id){
        Teacher teacher = teacherService.queryTeacherById(id);
        return R.success(teacher);
    }

    @PostMapping("/add/{count}")
    public R<String> addTeacher(@PathVariable Integer count ,@RequestBody Teacher teacher){
    // 添加教师暂时不考虑账号重复问题

        if(count != null){
            Count count1 = loginService.createCount(count, 1);

            System.out.println(count1.getId());

            teacher.setCountId(count1.getId());
            teacherService.addTeacher(teacher);
            return R.success("success");
        }else
            return R.error("无效账号");
    }

    @PutMapping
    public R<String> update(@RequestBody Teacher teacher){
        teacherService.updateTeacher(teacher);
        return R.success("success");
    }

    @DeleteMapping
    public R<String> delete(Integer[] ids){
        teacherService.deleteByIds(ids);
        return R.success("success");
    }

    @PutMapping("/status/{status}")
    public R<String> status(@PathVariable Integer status,Integer[] ids){
        teacherService.status(status,ids);
        return R.success("success");
    }
}
