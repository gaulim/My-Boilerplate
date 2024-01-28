package io.ssaragi.java.spring.boot.controller;

import io.ssaragi.java.spring.boot.dto.response.BaseApiResponseModel;
import io.ssaragi.java.spring.boot.exception.BusinessException;
import io.ssaragi.java.spring.boot.exception.SystemException;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

import static io.ssaragi.java.spring.boot.enums.ErrorCode.E0000;

@Slf4j
public abstract class BaseController {

    // 클래스/함수 이름 출력용 유틸 메서드
    protected void logFuncTitle(String funcTitle) {

        if ( log.isTraceEnabled() ) {
            final String className = this.getClass().getSimpleName();
            final String funcName = Thread.currentThread().getStackTrace()[2].getMethodName();
            if ( funcTitle == null )
                log.trace("== {}:{} ==", className, funcName);
            else
                log.trace("=== {}:{} ===", className, funcName);
        }

        // 함수 제목이 null 이 아닌 경우에만 로그로 출력
        if ( funcTitle != null ) log.info(funcTitle);
    }

    protected <T extends BaseApiResponseModel> T handle(String trId, Supplier<T> supplier) {
        try {
            T resModel = supplier.get();
            // Java 에서는 실행 시간에 제네릭 타입의 실제 클래스 이름을 로그로 남길 수 없음.
            resModel.setCode(E0000.getCode());
            resModel.setMessage(E0000.getMessage());
            resModel.setTrId(trId);
            log.debug("Response Model: {}", resModel);
            log.info("[RES - {}] [{}] {}", resModel.getTrId(), resModel.getCode(), resModel.getMessage());
            return resModel;
        } catch ( BusinessException e ) {
            throw new BusinessException(trId, e.getCode(), e.getMessage());
        } catch ( SystemException e) {
            throw new SystemException(trId, e);
        }
    }
}
