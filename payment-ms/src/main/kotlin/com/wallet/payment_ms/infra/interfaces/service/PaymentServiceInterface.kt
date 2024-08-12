package com.wallet.payment_ms.infra.interfaces.service

import com.wallet.payment_ms.infra.dto.PaymentDto
import java.util.UUID

interface PaymentServiceInterface {

    fun create(dto: PaymentDto): UUID

}
