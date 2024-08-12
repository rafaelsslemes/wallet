package com.wallet.withdraw_ms.infra.implementation.service

import com.wallet.withdraw_ms.entity.Withdraw
import com.wallet.withdraw_ms.infra.dto.WithdrawDto
import com.wallet.withdraw_ms.infra.interfaces.repository.WithdrawRepositoryInterface
import com.wallet.withdraw_ms.infra.interfaces.service.MessageServiceInterface
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.UUID

@ExtendWith(MockKExtension::class)

class WithdrawServiceTest {

    @MockK
    private lateinit var  withdrawRepositoryInterface: WithdrawRepositoryInterface

    @MockK
    private lateinit var  messageServiceInterface: MessageServiceInterface

    @InjectMockKs
    private lateinit var withdrawService: WithdrawService

    @Test
    fun `should create Withdraw`() {
        val userId = UUID.randomUUID()
        val mockWithdraw = Withdraw(UUID.randomUUID(), userId,100.00)
        every { withdrawRepositoryInterface.save(any()) } returns mockWithdraw
        every { messageServiceInterface.sendMessage(any(), any()) } returns Unit

        val withdrawId = withdrawService.create(WithdrawDto(userId, 100.00))

        assertEquals(mockWithdraw.id, withdrawId)
    }
}