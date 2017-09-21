package com.rkovtiuk.shortener

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * This class is developed by @author rkovtiuk on 17.09.17
 * for shortener in version com.rkovtiuk.shorter
 * under MIT license
 */

@SpringBootApplication
class ShortenerApplication

fun main(args: Array<String>) {
    SpringApplication.run(ShortenerApplication::class.java, *args)
}
