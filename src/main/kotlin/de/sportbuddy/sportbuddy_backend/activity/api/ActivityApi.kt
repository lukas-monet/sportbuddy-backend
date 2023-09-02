package de.sportbuddy.sportbuddy_backend.activity.api

import de.sportbuddy.sportbuddy_backend.activity.model.Activity
import de.sportbuddy.sportbuddy_backend.activity.repository.ActivityRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1")
class ActivityApi(
    private val activityRepository: ActivityRepository
) {

    @GetMapping(
        "/activity",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllActivities(): MutableIterable<Activity> {
        return activityRepository.findAll()
    }

    @GetMapping(
            "/activity/{id}",
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getActivitiesById(@PathVariable(value = "id") id: UUID): Activity {
        return activityRepository.findByIdOrNull(id) ?: throw BadRequestException("activity not found!")
    }

    @PutMapping(
            "/activity/{id}",
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateActivity(@PathVariable(value = "id") id: UUID,
                       @RequestBody @Validated inputActivity: Activity): Activity {
        val actvityToUpdate = activityRepository.findByIdOrNull(id) ?: throw BadRequestException("activity not found!")

        actvityToUpdate.time = inputActivity.time
        actvityToUpdate.location = inputActivity.location
        actvityToUpdate.numberOfPeople = inputActivity.numberOfPeople
        actvityToUpdate.typeOfSportActivity = inputActivity.typeOfSportActivity

        return activityRepository.save(actvityToUpdate)
    }

    @PostMapping(
            "/activity",
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createActivity(@RequestBody @Validated inputActivity: Activity): Activity {
        return activityRepository.save(inputActivity)
    }

    @DeleteMapping(
            "/activity/{id}",
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteActivity(@PathVariable(value = "id") id: UUID,
                       @RequestBody @Validated inputActivity: Activity) {
        val actvityToUpdate = activityRepository.findByIdOrNull(id) ?: throw BadRequestException("activity not found!")

        return activityRepository.delete(actvityToUpdate)
    }
}
