package com.wallet.payment_ms.infra.implementation.service

import com.wallet.payment_ms.entity.Payment
import com.wallet.payment_ms.infra.dto.PaymentDto
import com.wallet.payment_ms.infra.interfaces.repository.PaymentRepositoryInterface
import com.wallet.payment_ms.infra.interfaces.service.MessageServiceInterface
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.UUID

@ExtendWith(MockKExtension::class)

class PaymentServiceTest {

    @MockK
    private lateinit var  paymentRepositoryInterface: PaymentRepositoryInterface

    @MockK
    private lateinit var  messageServiceInterface: MessageServiceInterface
    @InjectMockKs
    private lateinit var paymentService: PaymentService


    @Test
    fun `should create Payment`() {
        val userId = UUID.randomUUID()
        val mockPayment = Payment(UUID.randomUUID(), userId,100.00)
        every { paymentRepositoryInterface.save(any()) } returns mockPayment
        every { messageServiceInterface.sendMessage(any(), any()) } returns Unit

        val depositId = paymentService.create(PaymentDto(userId, 100.00))

        assertEquals(mockPayment.id, depositId)
    }
}