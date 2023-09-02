package de.myjourneymate.myjourneymate.user.api

import de.myjourneymate.myjourneymate.user.model.Profile
import de.myjourneymate.myjourneymate.user.model.UserInput
import de.myjourneymate.myjourneymate.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal
import java.util.*

@RestController()
@RequestMapping("/api/v1")
class UserApi(
    private val userService: UserService
) {
    @CrossOrigin
    @PostMapping(
        "/user",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createUser(principal: Principal, @RequestBody userInput: UserInput): ResponseEntity<*> {
        return if (userService.createUser(userInput, principal.name)) {
            ResponseEntity(userInput, HttpStatus.CREATED)
        } else {
            ResponseEntity(userInput, HttpStatus.OK)
        }
    }


    @CrossOrigin
    @GetMapping(
        "/user",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getUser(principal: Principal): ResponseEntity<Profile> {
        val profile: Optional<Profile> = userService.getUser(principal.name);

        return if (profile.isPresent) {
            ResponseEntity(profile.get(), HttpStatus.OK)
        } else {
            ResponseEntity(null, HttpStatus.NO_CONTENT)
        }
    }
}
