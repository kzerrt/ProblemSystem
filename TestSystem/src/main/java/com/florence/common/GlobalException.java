package com.florence.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.ConnectException;

/**
 * @auther:Florence
 * @date:2022/07/13/9:45
 */
@ControllerAdvice(annotations = {RestController.class , Controller.class})
@ResponseBody
public class GlobalException {

    //用户填写的账户不存在
    @ExceptionHandler(NullPointerException.class)
    public R<String> exceptinoHandler(NullPointerException exception){
        return R.error("该账号不存在！！！");
    }

    @ExceptionHandler(ConnectException.class)
    public R<String> exceptinoHandler(){
        return R.error("数据库服务未开启!!");
    }


}
