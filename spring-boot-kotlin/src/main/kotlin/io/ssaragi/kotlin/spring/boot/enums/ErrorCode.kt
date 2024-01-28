package io.ssaragi.kotlin.spring.boot.enums

import io.ssaragi.kotlin.spring.boot.exception.BusinessException

enum class ErrorCode(val code: String, val message: String) {

    E0000("0000", "OK"),
    E9999("9999", "Unknown Error"),
    ;

    fun throwException(trId: String): Nothing {
        throw BusinessException(trId, code, message)
    }

    companion object {
        private val codeMap = enumValues<ErrorCode>().associateBy { it.code }

        fun findMessage(errorCode: ErrorCode): String? {
            return findMessageByCode(errorCode.code)
        }

        fun findMessageByCode(searchCode: String): String? {
            return codeMap[searchCode]?.message
        }
    }
}
