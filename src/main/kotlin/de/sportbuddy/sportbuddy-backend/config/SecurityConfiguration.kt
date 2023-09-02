package de.myjourneymate.myjourneymate.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration

class SecurityConfiguration {
    @Bean
    @Throws(Exception::class)
    @Profile("!test")
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests()
            .requestMatchers("/").permitAll()
            .requestMatchers("/cities-preview-unauth").permitAll()
            .anyRequest().authenticated()
            .and()
            .oauth2ResourceServer().jwt()


        http.cors().and().csrf().disable()
        return http.build()
    }

    @Bean
    @Throws(Exception::class)
    @Profile("test")
    fun securityFilterChainTest(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests()
            .requestMatchers("/**").permitAll()


        http.cors().and().csrf().disable()
        return http.build()
    }
}