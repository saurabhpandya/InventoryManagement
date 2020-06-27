package com.inventorymanagement

import com.inventorymanagement.model.base.AuditorAwareImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
open class JPAConfiguration {
    @Bean
    open fun auditorAware(): AuditorAware<String> {
        return AuditorAwareImpl()
    }

}