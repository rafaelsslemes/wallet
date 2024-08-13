package com.wallet.transactions_ms.infra.implementation.service

import com.wallet.transactions_ms.entity.Transaction
import com.wallet.transactions_ms.infra.dto.TransactionDto
import com.wallet.transactions_ms.infra.exception.TrasactionNotFoundException
import com.wallet.transactions_ms.infra.interfaces.repository.TransactionRepositoryInterface
import com.wallet.transactions_ms.infra.interfaces.service.TransactionServiceInterface
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TransactionService(
    val transactionRepositoryInterface: TransactionRepositoryInterface,
): TransactionServiceInterface {

    override fun create(dto: TransactionDto): UUID {
        val transaction = Transaction(null, dto.userId, dto.value, dto.transactionType, dto.movementType)
        val registered = transactionRepositoryInterface.save(transaction)
        return registered.id!!
    }

    override fun get(id: UUID): Transaction {

        val transaction = transactionRepositoryInterface.findById(id).orElseThrow { TrasactionNotFoundException("TRANSACTION_NOT_FOUND") }
        return transaction
    }

    override fun list(userId: UUID, page: Int): List<Transaction> {
        val transactions = transactionRepositoryInterface.findByUserIdAndMore(userId.toString(), page*10, 10).orEmpty()
        return transactions
    }

}