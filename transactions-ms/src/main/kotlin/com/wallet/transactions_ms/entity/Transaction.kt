package com.wallet.transactions_ms.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.JdbcTypeCode
import java.sql.Types
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity
data class Transaction (
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    @JdbcTypeCode(Types.VARCHAR)
    var id: UUID?,

    @JdbcTypeCode(Types.VARCHAR)
    val userId: UUID,
    val value: Double,
    val transactionType: TransactionType,
    val movementType: MovementType,
    val date: Date = Date.from(Instant.now())
) {
}