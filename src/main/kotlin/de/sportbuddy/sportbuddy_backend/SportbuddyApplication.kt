package de.sportbuddy.sportbuddy_backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
class SportbuddyApplication

fun main(args: Array<String>) {
    runApplication<SportbuddyApplication>(*args)
}
