package io.ssaragi.kotlin.spring.boot.dto.data.exam

import java.math.BigDecimal

data class ExamData(

    var valStr: String? = null,
    var valInt: Int? = null,
    var valLong: Long? = null,
    var valDecimal: BigDecimal? = null,
)
