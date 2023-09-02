package de.sportbuddy.sportbuddy_backend.activity.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
open class BadRequestException(message: String) : RuntimeException(message)

@ResponseStatus(HttpStatus.NOT_FOUND)
open class NotFoundException(message: String): RuntimeException(message)

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
open class InternalServerError(message: String): RuntimeException(message)