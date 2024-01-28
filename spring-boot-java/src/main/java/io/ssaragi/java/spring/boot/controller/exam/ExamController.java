package io.ssaragi.java.spring.boot.controller.exam;

import io.ssaragi.java.spring.boot.controller.BaseController;
import io.ssaragi.java.spring.boot.dto.request.exam.ExamReqBodyModel;
import io.ssaragi.java.spring.boot.dto.request.exam.ExamReqQueryModel;
import io.ssaragi.java.spring.boot.dto.response.BaseApiResponseModel;
import io.ssaragi.java.spring.boot.dto.response.exam.ExamDataResModel;
import io.ssaragi.java.spring.boot.dto.response.exam.ExamListResModel;
import io.ssaragi.java.spring.boot.service.exam.ExamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/v1/exam")
@RequiredArgsConstructor
public class ExamController extends BaseController {

    private final ExamService service;

    @PostMapping
    @ResponseBody
    public BaseApiResponseModel post(
            @RequestBody ExamReqBodyModel body
    ) {
        logFuncTitle("POST Request Example");
        return handle(UUID.randomUUID().toString(), () -> service.add(body));
    }

    @GetMapping
    @ResponseBody
    public ExamListResModel get(
            ExamReqQueryModel query
    ) {
        logFuncTitle("GET Request Find Multi Example");
        return handle(UUID.randomUUID().toString(), () -> service.find(query));
    }

    @GetMapping("{id}")
    @ResponseBody
    public ExamDataResModel get(
            @PathVariable("id") String id
    ) {
        logFuncTitle("GET Request Find One Example");
        return handle(UUID.randomUUID().toString(), () -> service.findById(id));
    }

    @PutMapping("{id}")
    @ResponseBody
    public BaseApiResponseModel put(
            @PathVariable("id") String id,
            ExamReqQueryModel query,
            @RequestBody ExamReqBodyModel body
    ) {
        logFuncTitle("PUT Request Example");
        return handle(UUID.randomUUID().toString(), () -> service.update(id, query, body));
    }

    @PatchMapping("{id}")
    @ResponseBody
    public BaseApiResponseModel patch(
            @PathVariable("id") String id,
            ExamReqQueryModel query,
            @RequestBody ExamReqBodyModel body
    ) {
        logFuncTitle("PATCH Request Example");
        return handle(UUID.randomUUID().toString(), () -> service.update(id, query, body));
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public BaseApiResponseModel delete(
            @PathVariable("id") String id,
            ExamReqQueryModel query
    ) {
        logFuncTitle("DELETE Request Example");
        return handle(UUID.randomUUID().toString(), () -> service.delete(id, query));
    }
}
