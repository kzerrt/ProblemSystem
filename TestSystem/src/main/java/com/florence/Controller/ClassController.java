package com.florence.Controller;

import com.florence.Dto.ClassManger;
import com.florence.Service.ClassService;
import com.florence.common.R;
import com.florence.pojo.Cal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/14/16:30
 */
@RestController
@RequestMapping("/class")
@Slf4j
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    /**
     * 获取分页信息
     * */
    @GetMapping("/page")
    public R<ClassManger> page(Integer page, Integer pageSize, String name){
        ClassManger classManger = null;
        if(name != null){
            name = '%' + name +'%';
        }
        classManger = classService.getPage(page - 1,pageSize,name);

        if(classManger == null)
            return R.error("暂无信息");
        else
            return R.success(classManger);

    }

    /**
     * 添加班级信息
     * */
    @PostMapping
    public R<String> addClass(@RequestBody Cal cal){

        classService.addClass(cal);

        return R.success("success");
    }

    @GetMapping("/query/{id}")
    public R<Cal> queryCalss(@PathVariable Integer id){
        System.out.println(id.toString());
        Cal cal = classService.queryClass(id);
        return R.success(cal);
    }

    @PutMapping
    public R<String> editClass(@RequestBody Cal cal){
        classService.updateInfo(cal);
        return R.success("success");
    }

    @DeleteMapping
    public R<String> delete(Integer[] ids){

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < ids.length; i++) {
            if(classService.queryClassNumberById(ids[i]) != 0){
                list.add(ids[i]);
                ids[i] = null;
            }
        }
        classService.deleteByIds(ids);
        if(list.isEmpty()) {
            list = null;
            return R.success("success");
        }
        else{
            String s = list.toString();
            list = null;
            return R.success("部分班级删除失败，原因为：班级编号为" + s + "的班级含有学生!");
        }

    }

    @PostMapping("/status/{status}")
    public R<String> status(@PathVariable Integer status,Integer[] ids){
        classService.status(status,ids);
        return R.success("success");
    }

}
