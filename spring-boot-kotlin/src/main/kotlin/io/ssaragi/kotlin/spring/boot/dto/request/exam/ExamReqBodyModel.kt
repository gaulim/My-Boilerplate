package io.ssaragi.kotlin.spring.boot.dto.request.exam

import java.math.BigDecimal

data class ExamReqBodyModel(

    var valStr: String? = null,
    var valInt: Int? = null,
    var valLong: Long? = null,
    var valDecimal: BigDecimal? = null,
)
