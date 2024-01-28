package io.ssaragi.kotlin.spring.boot.controller.exam

import io.ssaragi.kotlin.spring.boot.controller.BaseController
import io.ssaragi.kotlin.spring.boot.dto.request.exam.ExamReqBodyModel
import io.ssaragi.kotlin.spring.boot.dto.request.exam.ExamReqQueryModel
import io.ssaragi.kotlin.spring.boot.dto.response.BaseApiResponseModel
import io.ssaragi.kotlin.spring.boot.dto.response.exam.ExamDataResModel
import io.ssaragi.kotlin.spring.boot.dto.response.exam.ExamListResModel
import io.ssaragi.kotlin.spring.boot.service.exam.ExamService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1/exam")
class ExamController(

    private val service: ExamService,

) : BaseController() {

    @PostMapping
    @ResponseBody
    fun post(
        @RequestBody body: ExamReqBodyModel
    ): BaseApiResponseModel {
        logFuncTitle("POST Request Example")
        return handle(UUID.randomUUID().toString()) { service.add(body) }
    }

    @GetMapping
    @ResponseBody
    fun get(
        query: ExamReqQueryModel
    ): ExamListResModel {
        logFuncTitle("GET Request Find Multi Example")
        return handle(UUID.randomUUID().toString()) { service.find(query) }
    }

    @GetMapping("{id}")
    @ResponseBody
    fun get(
        @PathVariable("id") id: String
    ): ExamDataResModel {
        logFuncTitle("GET Request Find One Example")
        return handle(UUID.randomUUID().toString()) { service.findById(id) }
    }

    @PutMapping("{id}")
    @ResponseBody
    fun put(
        @PathVariable("id") id: String,
        query: ExamReqQueryModel,
        @RequestBody body: ExamReqBodyModel
    ): BaseApiResponseModel {
        logFuncTitle("PUT Request Example")
        return handle(UUID.randomUUID().toString()) { service.update(id, query, body) }
    }

    @PatchMapping("{id}")
    @ResponseBody
    fun patch(
        @PathVariable("id") id: String,
        query: ExamReqQueryModel,
        @RequestBody body: ExamReqBodyModel
    ): BaseApiResponseModel {
        logFuncTitle("PATCH Request Example")
        return handle(UUID.randomUUID().toString()) { service.update(id, query, body) }
    }

    @DeleteMapping("{id}")
    @ResponseBody
    fun delete(
        @PathVariable("id") id: String,
        query: ExamReqQueryModel
    ): BaseApiResponseModel {
        logFuncTitle("DELETE Request Example")
        return handle(UUID.randomUUID().toString()) { service.delete(id, query) }
    }
}
