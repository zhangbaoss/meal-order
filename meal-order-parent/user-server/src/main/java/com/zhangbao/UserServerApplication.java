package com.zhangbao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/15 13:49
 * @Version 1.0
 **/
@SpringBootApplication
@MapperScan("com.zhangbao.mapper")
public class UserServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }
}
