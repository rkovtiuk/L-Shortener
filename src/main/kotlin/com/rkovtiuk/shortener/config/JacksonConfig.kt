package com.rkovtiuk.shortener.config

import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * This class is developed by @author rkovtiuk on 24.09.17
 * for shortener in version com.rkovtiuk.shorter.config
 * under MIT license
 */

@Configuration
class JacksonConfig {

    @Bean open fun kotlinModule() = KotlinModule()

}