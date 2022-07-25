package com.florence.Controller;

import com.florence.Dto.CourseManger;
import com.florence.Service.CourseService;
import com.florence.common.R;
import com.florence.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @auther:Florence
 * @date:2022/07/19/17:16
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    
    @GetMapping("/page")
    public R<CourseManger> getPage(Integer page,Integer pageSize,String name){
        CourseManger page1 = courseService.getPage(page, pageSize, name);
        return R.success(page1);
    }

    @PostMapping("/add")
    public R<String> add(String name){

        courseService.addCourse(name);
        return R.success("success");
    }

    @PutMapping
    public R<String> update(@RequestBody Course course){
        courseService.updateInfo(course);
        return R.success("success");
    }

    @DeleteMapping
    public R<String> delete(Integer[] ids){
        courseService.deleteByIds(ids);
        return R.success("success");
    }

    @PostMapping("/status/{status}")
    public R<String> status(@PathVariable Integer status,Integer[] ids) {
        courseService.status(status, ids);
        return R.success("success");
    }

    @PostMapping("/addCourse/#{id}")
    public R<String> addCourse(@PathVariable Integer id,Integer username){
        courseService.addMyCourse(username,id);
        return R.success("success");
    }

    @PostMapping("/addClass")
    public R<String> addClass(Integer courseId,Integer classId,Integer userId){
        courseService.addClass(courseId,classId,userId);
        return R.success("success");
    }
}
