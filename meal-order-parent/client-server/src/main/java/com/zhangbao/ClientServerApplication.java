package com.zhangbao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/13 9:14
 * @Version 1.0
 **/
@SpringBootApplication
@EnableFeignClients
public class ClientServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServerApplication.class, args);
    }
}
