package com.florence;

import com.florence.Service.Impl.LoginServiceImp;
import com.florence.Service.LoginService;
import com.florence.pojo.Count;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestSystemApplicationTests {



    @Test
    void contextLoads() {
        LoginService loginService = new LoginServiceImp();
        Count login = loginService.login(123);
        System.out.println(login.toString());
    }

}
