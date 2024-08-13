package com.wallet.transactions_ms.infra.implementation.service

import com.wallet.transactions_ms.entity.MovementType
import com.wallet.transactions_ms.entity.Transaction
import com.wallet.transactions_ms.entity.TransactionType
import com.wallet.transactions_ms.infra.dto.TransactionDto
import com.wallet.transactions_ms.infra.interfaces.repository.TransactionRepositoryInterface
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.Optional
import java.util.UUID

@ExtendWith(MockKExtension::class)
class TransactionServiceTest{

@MockK
private lateinit var  transactionRepositoryInterface: TransactionRepositoryInterface

@InjectMockKs
private lateinit var transactionService: TransactionService

@Test
fun `should create Transaction`() {
  val mockTransaction = buildTransaction()
  every { transactionRepositoryInterface.save(any()) } returns mockTransaction

  val transactionId = transactionService.create(TransactionDto(mockTransaction.userId, mockTransaction.value, mockTransaction.transactionType, mockTransaction.movementType))

  assertEquals(transactionId, mockTransaction.id)
}


  @Test
  fun `should get Transaction`() {
    val mockTransaction = buildTransaction()

    every { transactionRepositoryInterface.findById(any()) } returns Optional.of(mockTransaction)

    val user = transactionService.get(mockTransaction.id!!)

    assertEquals(user, mockTransaction)
  }

private fun buildTransaction() = Transaction(UUID.randomUUID(), UUID.randomUUID(), 100.0, TransactionType.PAYMENT, MovementType.DEBIT )

}