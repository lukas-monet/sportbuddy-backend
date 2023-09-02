package de.myjourneymate.myjourneymate.user.service

import de.myjourneymate.myjourneymate.user.model.Profile
import de.myjourneymate.myjourneymate.user.model.User
import de.myjourneymate.myjourneymate.user.model.UserInput
import de.myjourneymate.myjourneymate.user.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*


@Service
class UserService(
    private val userRepository: UserRepository

) {
    fun createUser(userInput: UserInput, firebaseId: String): Boolean {

        val user = User(
            firebaseId = firebaseId,
            username = userInput.user,
            email = userInput.email,
            createdAt = ZonedDateTime.now(),
            lastLogin = ZonedDateTime.now(),
            level = 1
        )
        if (!isUserExisting(user.firebaseId)) {
            userRepository.save(user)
            return true;
        }
        return false
    }

    fun getUser(firebaseId: String): Optional<Profile> {
        val user = userRepository.findAllByFirebaseId(firebaseId);

        user.ifPresent { userEntry ->
            run {
                userEntry.lastLogin = ZonedDateTime.now()
                userRepository.save(userEntry)
            }
        }

        return user.map { data ->
            Profile(
                username = data.username,
                email = data.email,
                createdAt = data.createdAt.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                level = data.level
            )
        }
    }

    fun isUserExisting(firebaseId: String): Boolean {
        return userRepository.findAllByFirebaseId(firebaseId).isPresent;
    }
}