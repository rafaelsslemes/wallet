package com.wallet.transfer_ms.infra.dto

import java.util.UUID

data class TransactionDto (
    val userId: UUID,
    val value: Double,
    val transactionType: TransactionType,
    val movementType: MovementType,
) {
}