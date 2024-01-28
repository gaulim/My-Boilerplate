package io.ssaragi.java.spring.boot.service.exam;

import io.ssaragi.java.spring.boot.dto.data.exam.ExamData;
import io.ssaragi.java.spring.boot.dto.request.exam.ExamReqBodyModel;
import io.ssaragi.java.spring.boot.dto.request.exam.ExamReqQueryModel;
import io.ssaragi.java.spring.boot.dto.response.BaseApiResponseModel;
import io.ssaragi.java.spring.boot.dto.response.exam.ExamDataResModel;
import io.ssaragi.java.spring.boot.dto.response.exam.ExamListResModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Slf4j
@Service
public class ExamService {

    // 추가
    public BaseApiResponseModel add(ExamReqBodyModel body) {

        log.debug("Request Body Model: {}", body);

        return new BaseApiResponseModel();
    }

    // 여러건 조회
    public ExamListResModel find(ExamReqQueryModel query) {

        log.debug("Request Query Model: {}", query);

        var data = new ExamData();
        data.setValStr("ABC123");
        data.setValInt(1000000);
        data.setValLong(100000000000L);
        data.setValDecimal(new BigDecimal("10000.0000"));

        var list = new ArrayList<ExamData>();
        list.add(data);
        list.add(data);

        var resModel = new ExamListResModel();
        resModel.setList(list);
        return resModel;
    }

    // 한 건 조회
    public ExamDataResModel findById(String id) {

        log.info("ID: {}", id);

        var data = new ExamData();
        data.setValStr("ABC123");
        data.setValInt(1000000);
        data.setValLong(100000000000L);
        data.setValDecimal(new BigDecimal("10000.0000"));

        var resModel = new ExamDataResModel();
        resModel.setData(data);
        return resModel;
    }

    // 수정
    public BaseApiResponseModel update(String id, ExamReqQueryModel query, ExamReqBodyModel body) {

        log.info("ID: {}", id);
        log.debug("Request Query Model: {}", query);
        log.debug("Request Body Model: {}", body);

        return new BaseApiResponseModel();
    }

    // 삭제
    public BaseApiResponseModel delete(String id, ExamReqQueryModel query) {

        log.info("ID: {}", id);
        log.debug("Request Query Model: {}", query);

        return new BaseApiResponseModel();
    }
}
