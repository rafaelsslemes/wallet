package com.wallet.transactions_ms.infra.interfaces.repository

import com.wallet.transactions_ms.entity.Transaction
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

interface TransactionRepositoryInterface: CrudRepository<Transaction, UUID> {
    fun findTransactionByUserId(userId: UUID?): Transaction?

    @Query(value = "SELECT * FROM transaction t WHERE t.user_id = ?1 ORDER BY t.date desc limit ?3 offset ?2", nativeQuery = true)
    fun findByUserIdAndMore(userId: String?, offset: Int, limit: Int): List<Transaction>?
}