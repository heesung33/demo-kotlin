package com.demo.kr.demologback

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoLogbackApplication
private val log = LoggerFactory.getLogger(DemoLogbackApplication::class.java)
fun main(args: Array<String>) {
    runApplication<DemoLogbackApplication>(*args)
    log.info("logbackTest: " + "success")
}
