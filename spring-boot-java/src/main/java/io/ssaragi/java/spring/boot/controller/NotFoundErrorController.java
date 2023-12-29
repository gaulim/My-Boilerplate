package io.ssaragi.java.spring.boot.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotFoundErrorController implements ErrorController {

    // 기본으로 정의되어있는 /error 에 접속하면 없는 경로로 보이도록 재정의함
    @RequestMapping("/error")
    public ResponseEntity<Object> handleError() {
        return ResponseEntity.notFound().build();
    }
}
