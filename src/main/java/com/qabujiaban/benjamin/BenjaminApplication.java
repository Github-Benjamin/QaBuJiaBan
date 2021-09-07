package com.qabujiaban.benjamin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
// mybatis Mapper扫包
@MapperScan(basePackages = "com.qabujiaban.benjamin")
public class BenjaminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BenjaminApplication.class, args);
    }

}
