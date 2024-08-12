package com.wallet.deposit_ms.infra.implementation.service

import com.wallet.deposit_ms.entity.Deposit
import com.wallet.deposit_ms.infra.dto.DepositDto
import com.wallet.deposit_ms.infra.interfaces.repository.DepositRepositoryInterface
import com.wallet.deposit_ms.infra.interfaces.service.MessageServiceInterface
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.UUID

@ExtendWith(MockKExtension::class)

class DepositServiceTest {

    @MockK
    private lateinit var  depositRepositoryInterface: DepositRepositoryInterface

    @MockK
    private lateinit var  messageServiceInterface: MessageServiceInterface

    @InjectMockKs
    private lateinit var depositService: DepositService

    @Test
    fun `should create Deposit`() {
        val userId = UUID.randomUUID()
        val mockDeposit = Deposit(UUID.randomUUID(), userId,100.00)
        every { depositRepositoryInterface.save(any()) } returns mockDeposit
        every { messageServiceInterface.sendMessage(any(), any()) } returns Unit

        val depositId = depositService.create(DepositDto(userId, 100.00))

        assertEquals(mockDeposit.id, mockDeposit.id)
    }
}