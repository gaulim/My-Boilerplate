package io.ssaragi.kotlin.spring.boot.controller.exam

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.*

private val log = KotlinLogging.logger {}

private inline fun <reified T> T.className(): String = T::class.simpleName.toString()

@RestController
@RequestMapping("/v1/echo")
class EchoController {

    companion object {
        const val URL: String = "/v1/echo"
    }

    ////////////////////////////////////////////////////////////////////////////
    // 인라인 함수

    // 클래스/함수 이름 출력용 인라인 메서드
    // 로직상 반드시 inline 형태로 구현해야함.
    @Suppress("NOTHING_TO_INLINE")
    private inline fun logFuncTitle(funcTitle: String?) {

        if ( log.isTraceEnabled() ) {
            val funcName: String = Throwable().stackTrace[0].methodName
            if ( funcTitle == null )
                log.trace { "== ${className()}:$funcName ==" }
            else
                log.trace { "=== ${className()}:$funcName ===" }
        }

        // 함수 제목이 null 이 아닌 경우에만 로그로 출력
        funcTitle?.let { log.info { it } }
    }

    ////////////////////////////////////////////////////////////////////////////
    // API 컨트롤러

    /**
     * POST 에코 요청
     *
     * @param id      자원 ID
     * @param header  머릿 전달인자
     * @param params  전달인자 모음 맵
     *
     * @return 반환 후 스프링부트 프레임워크에 의해 자동으로 JSON 문자열로 변환됨
     */
    @PostMapping("{id}")
    fun echoPost(
        @PathVariable("id") id: String,
        @RequestHeader header: Map<String, Any>,
        @RequestParam params: Map<String, Any>
    ): Map<String, Any> {

        logFuncTitle("Echo POST Request")

        val uri = mapOf(
            "http_method" to "POST",
            "req_uri" to "$URL/$id",
            "id" to id
        )

        return makeResponse(uri, header, params)
    }

    /**
     * GET 에코 요청
     *
     * @param id      자원 ID
     * @param header  머릿 전달인자
     * @param params  전달인자 모음 맵
     *
     * @return 반환 후 스프링부트 프레임워크에 의해 자동으로 JSON 문자열로 변환됨
     */
    @GetMapping("{id}")
    fun echoGet(
        @PathVariable("id") id: String,
        @RequestHeader header: Map<String, Any>,
        @RequestParam params: Map<String, Any>
    ): Map<String, Any> {

        logFuncTitle("Echo GET Request")

        val uri = mapOf(
            "http_method" to "GET",
            "req_uri" to "$URL/$id",
            "id" to id
        )

        return makeResponse(uri, header, params)
    }

    /**
     * PUT 에코 요청
     *
     * @param id      자원 ID
     * @param header  머릿 전달인자
     * @param params  전달인자 모음 맵
     *
     * @return 반환 후 스프링부트 프레임워크에 의해 자동으로 JSON 문자열로 변환됨
     */
    @PutMapping("{id}")
    fun echoPut(
        @PathVariable("id") id: String,
        @RequestHeader header: Map<String, Any>,
        @RequestParam params: Map<String, Any>
    ): Map<String, Any> {

        logFuncTitle("Echo PUT Request")

        val uri = mapOf(
            "http_method" to "PUT",
            "req_uri" to "$URL/$id",
            "id" to id
        )

        return makeResponse(uri, header, params)
    }

    /**
     * PATCH 에코 요청
     *
     * @param id      자원 ID
     * @param header  머릿 전달인자
     * @param params  전달인자 모음 맵
     *
     * @return 반환 후 스프링부트 프레임워크에 의해 자동으로 JSON 문자열로 변환됨
     */
    @PatchMapping("{id}")
    fun echoPatch(
        @PathVariable("id") id: String,
        @RequestHeader header: Map<String, Any>,
        @RequestParam params: Map<String, Any>
    ): Map<String, Any> {

        logFuncTitle("Echo PATCH Request")

        val uri = mapOf(
            "http_method" to "PATCH",
            "req_uri" to "$URL/$id",
            "id" to id
        )

        return makeResponse(uri, header, params)
    }

    /**
     * DELETE 에코 요청
     *
     * @param id      자원 ID
     * @param header  머릿 전달인자
     * @param params  전달인자 모음 맵
     *
     * @return 반환 후 스프링부트 프레임워크에 의해 자동으로 JSON 문자열로 변환됨
     */
    @DeleteMapping("{id}")
    fun echoDelete(
        @PathVariable("id") id: String,
        @RequestHeader header: Map<String, Any>,
        @RequestParam params: Map<String, Any>
    ): Map<String, Any> {

        logFuncTitle("Echo DELETE Request")

        val uri = mapOf(
            "http_method" to "DELETE",
            "req_uri" to "$URL/$id",
            "id" to id
        )

        return makeResponse(uri, header, params)
    }

    ////////////////////////////////////////////////////////////////////////////
    // private method

    private fun makeResponse(
        uri: Map<String, Any>,
        header: Map<String, Any>,
        params: Map<String, Any>
    ): Map<String, Any> {

        logFuncTitle(null)

        val response = mutableMapOf<String, Any>()

        uri.forEach { (key, value) ->
            response[key] = value
            log.debug { "URI - $key: $value" }
        }

        header.forEach { (key, value) ->
            response[key] = value
            log.debug { "Header - $key: $value" }
        }

        params.forEach { (key, value) ->
            response[key] = value
            log.debug { "Params - $key: $value" }
        }

        return response
    }
}
