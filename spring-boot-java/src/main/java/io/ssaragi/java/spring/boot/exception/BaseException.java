package io.ssaragi.java.spring.boot.exception;

import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException {

    // 결과 코드 및 메세지
    private final String code;
    private final String message;

    // 트랜잭션 ID
    private final String trId;

    public BaseException(String trId, String code, String message) {
        this.code = code;
        this.message = message;
        this.trId = trId;
    }
}
