package io.ssaragi.kotlin.spring.boot

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

private val log = KotlinLogging.logger {}

@SpringBootApplication
class SpringBootKotlinApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinApplication>(*args)

    // 우아한 종료를 위한 종료 훅 추가
    Runtime.getRuntime().addShutdownHook(Thread {
        log.warn { "Application is shutting down..." }
        // 종료 시 수행할 작업
    })
}
