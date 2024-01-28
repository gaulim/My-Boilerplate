package io.ssaragi.kotlin.spring.boot.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import io.ssaragi.kotlin.spring.boot.dto.response.BaseApiResponseModel
import io.ssaragi.kotlin.spring.boot.enums.ErrorCode.E0000
import io.ssaragi.kotlin.spring.boot.exception.BusinessException
import io.ssaragi.kotlin.spring.boot.exception.SystemException

abstract class BaseController {

    protected val log = KotlinLogging.logger {}

    // 클래스/함수 이름 출력용 인라인 메서드
    // 로직상 반드시 inline 형태로 구현해야함.
    @Suppress("NOTHING_TO_INLINE")
    protected inline fun logFuncTitle(funcTitle: String?) {

        if ( log.isTraceEnabled() ) {
            val className = this.javaClass.simpleName
            val funcName = Thread.currentThread().stackTrace[1].methodName
            if ( funcTitle == null )
                log.trace { "== $className:$funcName ==" }
            else
                log.trace { "=== $className:$funcName ===" }
        }

        // 함수 제목이 null 이 아닌 경우에만 로그로 출력
        funcTitle?.let { log.info { it } }
    }

    protected inline fun <reified T : BaseApiResponseModel> handle(
        trId: String,
        noinline supplier: () -> T
    ): T {
        try {
            log.debug { "Handle response type: ${T::class.simpleName}" }
            return supplier().apply {
                code = E0000.code
                message = E0000.message
                this.trId = trId
                log.debug { "Response Model: $this" }
                log.info { "[RES - ${this.trId}] [${this.code}] ${this.message}" }
            }
        } catch (e: BusinessException) {
            throw BusinessException(trId, e.code, e.message)
        } catch (e: SystemException) {
            throw SystemException(trId, e)
        }
    }
}
