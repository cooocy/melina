package cc.dcyy.melina.interfaces.config

import er.rennala.advice.log.RequestLogAdvice
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AdviceConfig {

    @Bean
    fun requestLogAdvice(): RequestLogAdvice {
        return RequestLogAdvice()
    }

}