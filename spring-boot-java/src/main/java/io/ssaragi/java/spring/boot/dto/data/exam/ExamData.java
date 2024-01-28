package io.ssaragi.java.spring.boot.dto.data.exam;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ExamData {

    private String valStr;
    private Integer valInt;
    private Long valLong;
    private BigDecimal valDecimal;
}
