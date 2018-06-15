package com.mdx.user.provider;

import com.mdx.mybatis.annotation.EnableMybatis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMybatis(basePackage = "com.mdx.user.provider.dao",
        pojoPackage = "com.mdx.user.api.pojo.dto")
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
