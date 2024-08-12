package com.wallet.payment_ms.infra.interfaces.controller

import com.wallet.payment_ms.infra.dto.PaymentDto
import java.util.*

interface PaymentControllerInterface {
    fun create(dto: PaymentDto): UUID
}