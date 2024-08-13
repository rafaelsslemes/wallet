package com.wallet.transactions_ms.infra.implementation.controller

import com.wallet.transactions_ms.entity.Transaction
import com.wallet.transactions_ms.infra.dto.TransactionDto
import com.wallet.transactions_ms.infra.interfaces.controller.TransactionControllerInterface
import com.wallet.transactions_ms.infra.interfaces.service.TransactionServiceInterface
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("transactions")
class TransactionController(
    val transactionServiceInterface: TransactionServiceInterface
): TransactionControllerInterface {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    override fun get(@RequestParam id: UUID): Transaction {
        return transactionServiceInterface.get(id)

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    override fun create(@RequestBody dto: TransactionDto): UUID {
        val registeredId = transactionServiceInterface.create(dto)
        return registeredId

    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    override fun list(@RequestParam userId: UUID, @RequestParam page: Int): List<Transaction> {
        val transactions = transactionServiceInterface.list(userId, page)
        return transactions
    }
}