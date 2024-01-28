package io.ssaragi.java.spring.boot.exception;

public class BusinessException extends BaseException {

    public BusinessException(String trId, String code, String message) {
        super(trId, code, message);
    }
}
