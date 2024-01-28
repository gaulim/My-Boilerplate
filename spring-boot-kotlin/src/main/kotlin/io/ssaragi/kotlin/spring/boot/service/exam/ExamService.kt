package io.ssaragi.kotlin.spring.boot.service.exam

import io.github.oshai.kotlinlogging.KotlinLogging
import io.ssaragi.kotlin.spring.boot.dto.data.exam.ExamData
import io.ssaragi.kotlin.spring.boot.dto.request.exam.ExamReqBodyModel
import io.ssaragi.kotlin.spring.boot.dto.request.exam.ExamReqQueryModel
import io.ssaragi.kotlin.spring.boot.dto.response.BaseApiResponseModel
import io.ssaragi.kotlin.spring.boot.dto.response.exam.ExamDataResModel
import io.ssaragi.kotlin.spring.boot.dto.response.exam.ExamListResModel
import org.springframework.stereotype.Service
import java.math.BigDecimal

private val log = KotlinLogging.logger {}

@Service
class ExamService {

    // 추가
    fun add(model: ExamReqBodyModel): BaseApiResponseModel {

        log.debug { "Request Body Model: $model" }

        return BaseApiResponseModel()
    }

    // 여러 건 조회
    fun find(query: ExamReqQueryModel): ExamListResModel {

        log.debug { "Request Query Model: $query" }

        val data = ExamData("ABC123", 1000000, 100000000000L, BigDecimal("10000.0000"))
        val list = listOf(data)

        return ExamListResModel(list)
    }

    // 한 건 조회
    fun findById(id: String): ExamDataResModel {

        log.info { "ID: $id" }

        val data = ExamData("ABC123", 1000000, 100000000000L, BigDecimal("10000.0000"))

        return ExamDataResModel(data)
    }

    // 수정
    fun update(id: String, query: ExamReqQueryModel, body: ExamReqBodyModel): BaseApiResponseModel {

        log.info { "ID: $id" }
        log.debug { "Request Query Model: $query" }
        log.debug { "Request Body Model: $body" }

        return BaseApiResponseModel()
    }

    // 삭제
    fun delete(id: String, query: ExamReqQueryModel): BaseApiResponseModel {

        log.info { "ID: $id" }
        log.debug { "Request Query Model: $query" }

        return BaseApiResponseModel()
    }
}
