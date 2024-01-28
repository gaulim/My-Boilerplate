package io.ssaragi.java.spring.boot.enums;

import io.ssaragi.java.spring.boot.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 매우 중요: 코드 순서대로 선순으로 정렬해야함.
    E0000("0000", "OK"),
    E9999("9999", "Unknown Error"),
    ;

    private final String code;
    private final String message;

    public void throwException(String trId) throws BusinessException {
        throw new BusinessException(this.code, this.message, trId);
    }

    private static final Map<String, ErrorCode> codeMap = Map.copyOf(
        Arrays.stream(ErrorCode.values()).collect(Collectors.toMap(ErrorCode::getCode, e -> e))
    );

    public static String findMessage(ErrorCode errorCode) {
        return findMessageByCode(errorCode.getCode());
    }

    public static String findMessageByCode(String searchCode) {
        return codeMap.getOrDefault(searchCode, null).getMessage();
    }
}
