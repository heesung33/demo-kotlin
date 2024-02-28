package com.demo.kr.demograylog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoGraylogApplication

fun main(args: Array<String>) {
    runApplication<DemoGraylogApplication>(*args)
}
