package io.ssaragi.kotlin.spring.boot

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.NoHandlerFoundException
import org.springframework.http.ResponseEntity

@ControllerAdvice
class CustomExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException::class)
    fun handleNoHandlerFoundException(e: NoHandlerFoundException): ResponseEntity<String> {
        return ResponseEntity.notFound().build()
    }
}
