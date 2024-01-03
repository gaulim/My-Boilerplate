package io.ssaragi.java.spring.boot.controller.exam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/v1/echo")
public class EchoController {

    private static final String URL = "/v1/echo";

    ////////////////////////////////////////////////////////////////////////////
    // 유틸 함수

    // 클래스/함수 이름 출력용 유틸 메서드
    private void logFuncTitle(String funcTitle) {

        if ( log.isTraceEnabled() ) {
            final String className = this.getClass().getSimpleName();
            final String funcName = Thread.currentThread().getStackTrace()[1].getMethodName();
            if ( funcTitle == null )
                log.trace("== {}:{} ==", className, funcName);
            else
                log.trace("=== {}:{} ===", className, funcName);
        }

        // 함수 제목이 null 이 아닌 경우에만 로그로 출력
        if ( funcTitle != null ) log.info(funcTitle);
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
    public Map<String, Object> echoPost(
        @PathVariable("id") String id,
        @RequestHeader Map<String, Object> header,
        @RequestParam Map<String, Object> params
    ) {
        logFuncTitle("Echo POST Request");

        Map<String, Object> uri = Map.of(
            "http_method", "POST",
            "req_uri", URL + "/" + id,
            "id", id
        );

        return makeResponse(uri, header, params);
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
    public Map<String, Object> echoGet(
        @PathVariable("id") String id,
        @RequestHeader Map<String, Object> header,
        @RequestParam Map<String, Object> params
    ) {
        logFuncTitle("Echo GET Request");

        Map<String, Object> uri = Map.of(
            "http_method", "GET",
            "req_uri", URL + "/" + id,
            "id", id
        );

        return makeResponse(uri, header, params);
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
    public Map<String, Object> echoPut(
        @PathVariable("id") String id,
        @RequestHeader Map<String, Object> header,
        @RequestParam Map<String, Object> params
    ) {
        logFuncTitle("Echo PUT Request");

        Map<String, Object> uri = Map.of(
            "http_method", "PUT",
            "req_uri", URL + "/" + id,
            "id", id
        );

        return makeResponse(uri, header, params);
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
    public Map<String, Object> echoPatch(
        @PathVariable("id") String id,
        @RequestHeader Map<String, Object> header,
        @RequestParam Map<String, Object> params
    ) {
        logFuncTitle("Echo PATCH Request");

        Map<String, Object> uri = Map.of(
            "http_method", "PATCH",
            "req_uri", URL + "/" + id,
            "id", id
        );

        return makeResponse(uri, header, params);
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
    public Map<String, Object> echoDelete(
        @PathVariable("id") String id,
        @RequestHeader Map<String, Object> header,
        @RequestParam Map<String, Object> params
    ) {
        logFuncTitle("Echo DELETE Request");

        Map<String, Object> uri = Map.of(
            "http_method", "DELETE",
            "req_uri", URL + "/" + id,
            "id", id
        );

        return makeResponse(uri, header, params);
    }

    ////////////////////////////////////////////////////////////////////////////
    // private static method

    private Map<String, Object> makeResponse(
        Map<String, Object> uri,
        Map<String, Object> header,
        Map<String, Object> params
    ) {
        logFuncTitle(null);

        Map<String, Object> response = new HashMap<>();

        uri.forEach((key, value) -> {
            response.put(key, value);
            log.debug("URI - {}: {}", key, value);
        });

        header.forEach((key, value) -> {
            response.put(key, value);
            log.debug("Header - {}: {}", key, value);
        });

        params.forEach((key, value) -> {
            response.put(key, value);
            log.debug("Params - {}: {}", key, value);
        });

        return response;
    }
}
