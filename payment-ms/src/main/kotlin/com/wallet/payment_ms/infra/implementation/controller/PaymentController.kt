package com.wallet.payment_ms.infra.implementation.controller

import com.wallet.payment_ms.infra.interfaces.controller.PaymentControllerInterface
import com.wallet.payment_ms.infra.interfaces.service.PaymentServiceInterface
import com.wallet.payment_ms.infra.dto.PaymentDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("payments")
class PaymentController (
    val paymentServiceInterface: PaymentServiceInterface
): PaymentControllerInterface {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    override fun create(dto: PaymentDto): UUID {
        val registeredId = paymentServiceInterface.create(dto)

        return registeredId
    }
}