package com.zhangbao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Hello world!
 *
 * @author zhangbao
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
