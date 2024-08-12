package com.wallet.payment_ms.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity
data class Payment (
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    var id: UUID?,

    var userId: UUID,
    var value: Double,
    var date: Date? = Date.from(Instant.now())
) {}