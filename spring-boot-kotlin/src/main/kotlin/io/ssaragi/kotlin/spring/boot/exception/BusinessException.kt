package io.ssaragi.kotlin.spring.boot.exception

class BusinessException(trId: String, code: String, message: String) : BaseException(trId, code, message)
