package com.demo.kr.demologback

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoLogbackApplication

fun main(args: Array<String>) {
    runApplication<DemoLogbackApplication>(*args)
}
