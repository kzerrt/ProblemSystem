package com.florence.Controller;

import com.florence.Service.LoginService;
import com.florence.common.BaseContext;
import com.florence.common.R;
import com.florence.pojo.Count;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
    public R<Count> Login(@RequestBody Count count, boolean remember, HttpServletResponse response) {
        //log.info(count.toString() + "   " + remember);
        //获取用户填写的信息

        //从数据库中获取该账号信息

        Count login = null;
        login = loginService.login(count.getUsername());


        if (count.getPassword().equals(login.getPassword())) {
            if (remember) {
                Cookie username = new Cookie("username", login.getUsername().toString());
                Cookie password = new Cookie("password", login.getPassword());

                username.setMaxAge(60 * 5);
                password.setMaxAge(60 * 5);
                response.addCookie(username);
                response.addCookie(password);
            }
            BaseContext.setCurrentId(login.getUsername());

            return R.success(login);
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
