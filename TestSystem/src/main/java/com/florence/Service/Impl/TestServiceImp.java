package com.florence.Service.Impl;

import com.florence.Dto.ProblemManger;
import com.florence.Service.TestService;
import com.florence.dao.TestMapper;
import com.florence.pojo.Category;
import com.florence.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther:Florence
 * @date:2022/07/25/15:56
 */
@Service
public class TestServiceImp implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public ProblemManger getPage(Integer page, Integer pageSize, String name) {
        List<Problem> page1 = testMapper.getPage(page, pageSize, name);
        Integer total = testMapper.getTotal(name);
        ProblemManger t = new ProblemManger();
        t.setTotal(total);
        t.setList(page1);
        return null;
    }

    @Override
    public void deleteById(Integer[] ids) {
        testMapper.deleteByIds(ids);
    }

    @Override
    public List<Category> getCategory() {
        return testMapper.getCategory();
    }

    @Override
    public void addProblem(Problem problem) {
        testMapper.addProblem(problem);
    }

    @Override
    public Problem queryById(Integer id) {

        return testMapper.queryById(id);
    }

    @Override
    public void updateProblem(Problem problem) {
        testMapper.updateProblem(problem);
    }
}
