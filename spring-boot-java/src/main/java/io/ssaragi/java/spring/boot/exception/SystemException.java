package io.ssaragi.java.spring.boot.exception;

import lombok.Getter;

@Getter
public class SystemException extends RuntimeException {

    private final String trId;
    private final Exception exception;

    public SystemException(String trId, Exception e) {
        this.trId = trId;
        this.exception = e;
    }
}
