package com.zhangbao.controller;

import com.zhangbao.service.AccountService;
import com.zhangbao.vo.PoJoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/16 9:46
 * @Version 1.0
 **/
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public PoJoVo<?> login(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("type") String type) {
        return accountService.login(username, password, type);
    }
}
