package com.florence.Service;

import com.florence.Dto.ProblemManger;
import com.florence.pojo.Category;
import com.florence.pojo.Problem;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/25/15:56
 */
public interface TestService {
    ProblemManger getPage(Integer page, Integer pageSize, String name);
    void deleteById(Integer[] ids);
    List<Category> getCategory();
    void addProblem(Problem problem);
    Problem queryById(Integer id);
    void updateProblem(Problem problem);
}
