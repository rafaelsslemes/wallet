package com.wallet.transfer_ms.infra.implementation.service

import com.wallet.transfer_ms.entity.Transfer
import com.wallet.transfer_ms.infra.dto.*
import com.wallet.transfer_ms.infra.interfaces.repository.TransferRepositoryInterface
import com.wallet.transfer_ms.infra.interfaces.service.MessageServiceInterface
import com.wallet.transfer_ms.infra.interfaces.service.TransferServiceInterface
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TransferService(
    val transferRepositoryInterface: TransferRepositoryInterface,
    val messageServiceInterface: MessageServiceInterface
): TransferServiceInterface {

    private final val topic = "transactions"

    override fun create(dto: TransferDto): UUID {
        val registered = transferRepositoryInterface.save(Transfer(null, dto.payerUserId, dto.receiverUserId, dto.value))

        try {
            // Outcome from payer
            messageServiceInterface.sendMessage(topic, TransactionDto(
                registered.payerUserId, registered.value, TransactionType.TRANSFER, MovementType.DEBIT)
            )

            // Income to receiver
            messageServiceInterface.sendMessage(topic, TransactionDto(
                registered.receiverUserId, registered.value, TransactionType.TRANSFER, MovementType.CREDIT)
            )
        }catch (e:Exception){
            println(e)
        }
        return registered.id!!
    }
}



