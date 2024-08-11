package com.wallet.account_ms.entity

import jakarta.persistence.*
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity
data class Balance (

    @Id
    @Column (name = "user_id")
    var id: UUID?,

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @MapsId
    @JoinColumn(name = "user_id")
    var user: User?,

    var value: Double,
    var updatedAt: Date = Date.from(Instant.now())
) {}