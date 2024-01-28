package io.ssaragi.kotlin.spring.boot.dto.response.exam

import io.ssaragi.kotlin.spring.boot.dto.data.exam.ExamData
import io.ssaragi.kotlin.spring.boot.dto.response.BaseApiResponseModel

data class ExamListResModel(

    var list: List<ExamData>? = null,

) : BaseApiResponseModel()
