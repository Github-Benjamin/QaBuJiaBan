package com.qabujiaban.benjamin;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


// loginAuth 登陆拦截器 ；  与日志拦截器冲突  WebLogAspect loginAuth
@ServletComponentScan()
@SpringBootApplication
// mybatis Mapper扫包
@MapperScan(basePackages = "com.qabujiaban.benjamin")
public class BenjaminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BenjaminApplication.class, args);
    }

}
