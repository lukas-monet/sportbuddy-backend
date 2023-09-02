package de.sportbuddy.sportbuddy_backend.activity.repository

import de.sportbuddy.sportbuddy_backend.activity.model.Activity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ActivityRepository : CrudRepository<Activity, UUID> {

}