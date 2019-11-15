package com.zhangbao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/12 15:55
 * @Version 1.0
 **/
@RestController
public class OrderController {

    @Value("${server.port}")
    private String port;

    @GetMapping
    public String index() {
        return "order服务端口为: " + this.port;
    }
}
