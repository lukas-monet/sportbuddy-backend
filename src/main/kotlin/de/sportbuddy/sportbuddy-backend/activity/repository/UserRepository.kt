package de.myjourneymate.myjourneymate.user.repository

import de.myjourneymate.myjourneymate.user.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun findAllByFirebaseId(firebaseId: String): Optional<User>
}