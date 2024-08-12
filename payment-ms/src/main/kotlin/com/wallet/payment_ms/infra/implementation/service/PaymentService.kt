package com.wallet.payment_ms.infra.implementation.service

import com.wallet.payment_ms.infra.interfaces.repository.PaymentRepositoryInterface
import com.wallet.payment_ms.infra.dto.MovementType
import com.wallet.payment_ms.infra.dto.TransactionDto
import com.wallet.payment_ms.infra.dto.TransactionType
import com.wallet.payment_ms.entity.Payment
import com.wallet.payment_ms.infra.dto.PaymentDto
import com.wallet.payment_ms.infra.interfaces.service.PaymentServiceInterface
import com.wallet.payment_ms.infra.interfaces.service.MessageServiceInterface
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PaymentService(
    val paymentRepositoryInterface: PaymentRepositoryInterface,
    val messageServiceInterface: MessageServiceInterface
): PaymentServiceInterface {

    private final val topic = "transactions"

    override fun create(dto: PaymentDto): UUID {
        val registered = paymentRepositoryInterface.save(Payment(null, dto.userId, dto.value))

        try {
            messageServiceInterface.sendMessage(topic, TransactionDto(
                registered.userId, registered.value, TransactionType.PAYMENT, MovementType.DEBIT)
            )
        }catch (e:Exception){
            println(e)
        }
        return registered.id!!
    }
}



