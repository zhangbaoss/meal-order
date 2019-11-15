package com.zhangbao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/12 17:55
 * @Version 1.0
 **/
@MapperScan("com.zhangbao.mapper")
@SpringBootApplication
public class MenuServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MenuServerApplication.class, args);
    }
}
