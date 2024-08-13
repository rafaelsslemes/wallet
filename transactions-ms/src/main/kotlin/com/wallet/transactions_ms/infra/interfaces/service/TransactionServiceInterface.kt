package com.wallet.transactions_ms.infra.interfaces.service

import com.wallet.transactions_ms.entity.Transaction
import com.wallet.transactions_ms.infra.dto.TransactionDto
import java.util.UUID

interface TransactionServiceInterface {

    fun create(dto: TransactionDto) : UUID
    fun get(id: UUID): Transaction
    fun list(userId: UUID, page: Int): List<Transaction>

}