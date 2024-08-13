package com.wallet.transactions_ms.infra.dto

import com.wallet.transactions_ms.entity.MovementType
import com.wallet.transactions_ms.entity.TransactionType
import java.util.UUID

data class TransactionDto (
    val userId: UUID,
    val value: Double,
    val transactionType: TransactionType,
    val movementType: MovementType,
) {
}