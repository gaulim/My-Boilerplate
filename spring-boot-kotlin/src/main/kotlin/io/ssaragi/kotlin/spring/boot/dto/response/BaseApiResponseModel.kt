package io.ssaragi.kotlin.spring.boot.dto.response

import io.ssaragi.kotlin.spring.boot.enums.ErrorCode

open class BaseApiResponseModel(

    // 결과 코드 및 메세지
    var code: String? = null,
    var message: String? = null,

    // 트랜잭션 ID
    var trId: String? = null,
) {
    private inline fun <reified T> T.className(): String = T::class.simpleName.toString()

    companion object {
        fun from(errorCode: ErrorCode, trId: String) = BaseApiResponseModel(
            code = errorCode.code,
            message = errorCode.message,
            trId = trId,
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as BaseApiResponseModel

        if (code != other.code) return false
        if (message != other.message) return false
        if (trId != other.trId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = code?.hashCode() ?: 0
        result = 31 * result + (message?.hashCode() ?: 0)
        result = 31 * result + (trId?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "${className()}(code=$code, message=$message, trId=$trId)"
    }
}
