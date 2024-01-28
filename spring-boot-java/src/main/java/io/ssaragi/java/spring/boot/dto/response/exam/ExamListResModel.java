package io.ssaragi.java.spring.boot.dto.response.exam;

import io.ssaragi.java.spring.boot.dto.data.exam.ExamData;
import io.ssaragi.java.spring.boot.dto.response.BaseApiResponseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class ExamListResModel extends BaseApiResponseModel {

    private List<ExamData> list;
}
