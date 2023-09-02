package de.myjourneymate.myjourneymate.user.model

import jakarta.persistence.*
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import java.time.ZonedDateTime

@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    val firebaseId: String,

    @Column(nullable = false)
    val username: String,

    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    @field:DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @set:DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var createdAt: ZonedDateTime = ZonedDateTime.now(),

    @Column(nullable = false)
    @field:DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @set:DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var lastLogin: ZonedDateTime = ZonedDateTime.now(),

    @Column(nullable = false)
    var level:Int,
)
