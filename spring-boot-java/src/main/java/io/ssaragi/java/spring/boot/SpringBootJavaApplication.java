package io.ssaragi.java.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJavaApplication.class, args);

        // 우아한 종료를 위한 종료 훅 추가
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Application is shutting down...");
            // 종료 시 수행할 작업
        }));
    }

}
