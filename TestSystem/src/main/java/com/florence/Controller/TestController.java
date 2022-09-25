package com.florence.Controller;

import com.florence.Dto.ProblemManger;
import com.florence.Service.TestService;
import com.florence.common.BaseContext;
import com.florence.common.R;
import com.florence.pojo.Category;
import com.florence.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther :Florence
 * @date:2022/07/25/15:57
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/page")
    public R<ProblemManger> getPage(Integer page,Integer pageSize,String name){
        ProblemManger page1 = testService.getPage(page - 1, pageSize, name);
        return R.success(page1);
    }

    @DeleteMapping
    public R<String> delete(Integer[] ids){
        testService.deleteById(ids);
        return R.success("success");
    }

    @GetMapping("/category")
    public R<List<Category>> getCategory(){
        List<Category> category = testService.getCategory();
        return R.success(category);
    }

    @PostMapping("/add")
    public R<String> add(@RequestBody Problem problem){
        problem.setTeaId(BaseContext.getCurrentId().intValue());
        testService.addProblem(problem);
        return R.success("success");
    }

    @GetMapping("/query/{id}")
    public R<Problem> query(@PathVariable Integer id){
        Problem problem = testService.queryById(id);
        return R.success(problem);
    }

    @PutMapping
    public R<String> update(@RequestBody Problem problem){
        testService.updateProblem(problem);
        return R.success("success");
    }
}
