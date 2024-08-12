package com.wallet.transfer_ms.infra.implementation.service

import com.wallet.transfer_ms.entity.Transfer
import com.wallet.transfer_ms.infra.dto.TransferDto
import com.wallet.transfer_ms.infra.interfaces.repository.TransferRepositoryInterface
import com.wallet.transfer_ms.infra.interfaces.service.MessageServiceInterface
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.UUID

@ExtendWith(MockKExtension::class)

class TransferServiceTest {

    @MockK
    private lateinit var  transferRepositoryInterface: TransferRepositoryInterface

    @MockK
    private lateinit var  messageServiceInterface: MessageServiceInterface

    @InjectMockKs
    private lateinit var transferService: TransferService

    @Test
    fun `should create Transfer`() {

        val payerId = UUID.randomUUID()
        val receiverId = UUID.randomUUID()

        val mockTransfer = Transfer(UUID.randomUUID(), payerId, receiverId,100.00)
        every { transferRepositoryInterface.save(any()) } returns mockTransfer
        every { messageServiceInterface.sendMessage(any(), any()) } returns Unit

        val transferId = transferService.create(TransferDto(payerId, receiverId, 100.00))

        assertEquals(mockTransfer.id, transferId)
    }
}