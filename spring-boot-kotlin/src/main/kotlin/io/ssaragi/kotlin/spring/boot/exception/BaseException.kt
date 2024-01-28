package io.ssaragi.kotlin.spring.boot.exception

open class BaseException(

    // 결과 코드 및 메세지
    val code: String,
    override val message: String,

    // 트랜잭션 ID
    val trId: String,

) : RuntimeException(message)
