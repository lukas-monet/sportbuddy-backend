package de.myjourneymate.myjourneymate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SportbuddyApplication

fun main(args: Array<String>) {
    runApplication<MyJourneyMateApplication>(*args)
}
