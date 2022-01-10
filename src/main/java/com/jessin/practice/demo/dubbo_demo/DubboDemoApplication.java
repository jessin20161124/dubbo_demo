package com.jessin.practice.demo.dubbo_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
  java -Dspring.profiles.active=provider -Dserver.port=8081 -jar target/dubbo_demo-0.0.1-SNAPSHOT.jar

 java -Dspring.profiles.active=consumer -Dserver.port=8082 -jar target/dubbo_demo-0.0.1-SNAPSHOT.jar
 */
@SpringBootApplication
public class DubboDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboDemoApplication.class, args);
    }

}
