package com.rkovtiuk.shortener

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ShortenerApplication

fun main(args: Array<String>) {
    SpringApplication.run(ShortenerApplication::class.java, *args)
}
