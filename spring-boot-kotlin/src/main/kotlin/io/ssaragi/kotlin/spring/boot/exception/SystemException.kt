package io.ssaragi.kotlin.spring.boot.exception

class SystemException(

    val trId: String,
    val exception: Exception,

) : RuntimeException()
