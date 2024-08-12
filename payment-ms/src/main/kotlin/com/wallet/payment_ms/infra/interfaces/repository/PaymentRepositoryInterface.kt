package com.wallet.payment_ms.infra.interfaces.repository

import com.wallet.payment_ms.entity.Payment
import org.springframework.data.repository.CrudRepository
import java.util.*

interface PaymentRepositoryInterface: CrudRepository<Payment, UUID> {
}