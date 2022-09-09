package com.easyEat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author BDsnake
 * @since 2022/9/9 10:28
 */
@SpringBootApplication
@MapperScan("com.easyEat.mapper")
public class ApplicationMain {
     public static void main(String[] args) {
           SpringApplication.run(ApplicationMain.class, args);
      }
     
}
