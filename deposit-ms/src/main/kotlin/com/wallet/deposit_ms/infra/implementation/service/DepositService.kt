package com.wallet.deposit_ms.infra.implementation.service

import com.wallet.account_ms.infra.dto.MovementType
import com.wallet.account_ms.infra.dto.TransactionDto
import com.wallet.account_ms.infra.dto.TransactionType
import com.wallet.deposit_ms.entity.Deposit
import com.wallet.deposit_ms.infra.dto.DepositDto
import com.wallet.deposit_ms.infra.interfaces.repository.DepositRepositoryInterface
import com.wallet.deposit_ms.infra.interfaces.service.DepositServiceInterface
import com.wallet.deposit_ms.infra.interfaces.service.MessageServiceInterface
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DepositService(
    val depositRepositoryInterface: DepositRepositoryInterface,
    val messageServiceInterface: MessageServiceInterface
): DepositServiceInterface {

    private final val topic = "transactions"

    override fun create(dto: DepositDto): UUID {
        val registered = depositRepositoryInterface.save(Deposit(null, dto.userId, dto.value))

        try {
            messageServiceInterface.sendMessage(topic, TransactionDto(
                registered.userId, registered.value, TransactionType.DEPOSIT, MovementType.CREDIT)
            )
        }catch (e:Exception){
            println(e)
        }
        return registered.id!!
    }
}



