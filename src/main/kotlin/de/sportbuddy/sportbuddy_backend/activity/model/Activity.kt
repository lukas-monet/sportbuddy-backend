package de.sportbuddy.sportbuddy_backend.activity.model

import de.sportbuddy.sportbuddy_backend.activity.model.enums.TypeOfSportActivity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.util.UUID

@Entity
data class Activity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: UUID = UUID.randomUUID(),
        var userId: UUID,
        var typeOfSportActivity: TypeOfSportActivity,
        var location: String,
        var numberOfPeople: Int,
        var time: LocalDateTime
)