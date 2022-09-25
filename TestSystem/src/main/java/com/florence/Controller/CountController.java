package com.florence.Controller;

import com.alibaba.fastjson.JSON;
import com.florence.Dto.LoginDto;
import com.florence.Service.LoginService;
import com.florence.common.BaseContext;
import com.florence.common.R;
import com.florence.pojo.Count;
import com.florence.pojo.Students;
import com.florence.pojo.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @auther:Florence
 * @date:2022/07/13/9:01
 */
@RestController
@RequestMapping("/count")
@Slf4j
public class CountController {

    private final LoginService loginService;

    public CountController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 将用户输入的信息判断，是否可以登录
     */
    @PostMapping("/login")
    public R<LoginDto> Login(@RequestBody Count count, boolean remember, HttpServletResponse response, HttpServletRequest request) {
        //log.info(count.toString() + "   " + remember);
        //获取用户填写的信息

        //从数据库中获取该账号信息

        Count login = null;
        LoginDto loginDto = new LoginDto();
        login = loginService.login(count.getUsername());

        assert login != null;
        if (count.getPassword().equals(login.getPassword())) {
            if (remember) {
                Cookie username = new Cookie("username", login.getUsername().toString());
                Cookie password = new Cookie("password", login.getPassword());

                username.setMaxAge(60 * 5);
                password.setMaxAge(60 * 5);
                response.addCookie(username);
                response.addCookie(password);
            }
           // BaseContext.setCurrentId(login.getUsername());
            if(login.getType() != 0){
                if(login.getType() == 1){
                    Teacher teacher = loginService.getTeacher(login.getId());
                    loginDto.setType(JSON.toJSONString(teacher));
                }else{
                    Students student = loginService.getStudent(login.getId());
                    assert student != null;
                    loginDto.setType(JSON.toJSONString(student));
                }
            }
            loginDto.setCounts(login);
            return R.success(loginDto);
        } else {
            return R.error("账户密码错误!!");
        }


    }

    @GetMapping("/logout")
    public R<String> logout(){
        BaseContext.remove();
        return R.success("success");
    }

}
