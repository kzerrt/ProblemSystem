package com.florence.Controller;

import com.florence.Dto.StudentManger;
import com.florence.Service.LoginService;
import com.florence.Service.StudentService;
import com.florence.common.R;
import com.florence.pojo.Count;
import com.florence.pojo.Students;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther:Florence
 * @date:2022/07/18/10:02
 */
@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private LoginService loginService;

    @GetMapping("/page")
    public R<StudentManger> getPage(Integer page, Integer pageSize, String name){

        if(name != null){
            name = '%' + name + '%';
        }
        StudentManger list = studentService.getPage(page - 1, pageSize, name);
        return R.success(list);
    }

    @GetMapping("/query/{id}")
    public R<Students> queryById(@PathVariable Integer id){
        Students student = studentService.queryStudentById(id);
        return R.success(student);
    }

    @PostMapping("/add/{count}")
    public R<String> addstudent(@PathVariable Integer count ,@RequestBody Students student){
    // 添加教师暂时不考虑账号重复问题

        if(count != null){
            Count count1 = loginService.createCount(count, 2);

            System.out.println(count1.getId());

            student.setCountId(count1.getId());
            studentService.addStudent(student);
            return R.success("success");
        }else
            return R.error("无效账号");
    }

    @PutMapping
    public R<String> update(@RequestBody Students student){
        studentService.updateStudent(student);
        return R.success("success");
    }

    @DeleteMapping
    public R<String> delete(Integer[] ids){
        studentService.deleteByIds(ids);
        return R.success("success");
    }

    @PostMapping("/status/{status}")
    public R<String> status(@PathVariable Integer status,Integer[] ids){
        studentService.status(status,ids);
        return R.success("success");
    }
}
