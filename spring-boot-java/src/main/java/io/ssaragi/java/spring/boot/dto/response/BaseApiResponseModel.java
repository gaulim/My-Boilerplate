package io.ssaragi.java.spring.boot.dto.response;

import io.ssaragi.java.spring.boot.enums.ErrorCode;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseApiResponseModel {

    // 결과 코드 및 메세지
    protected String code;
    protected String message;

    // 트랜잭션 ID
    protected String trId;

    public static BaseApiResponseModel from(ErrorCode errorCode, String trId) {
        return BaseApiResponseModel.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .trId(trId)
                .build();
    }
}
