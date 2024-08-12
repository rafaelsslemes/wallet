package com.wallet.withdraw_ms.infra.implementation.service

import com.wallet.withdraw_ms.infra.dto.MovementType
import com.wallet.withdraw_ms.infra.dto.TransactionDto
import com.wallet.withdraw_ms.infra.dto.TransactionType
import com.wallet.withdraw_ms.entity.Withdraw
import com.wallet.withdraw_ms.infra.dto.WithdrawDto
import com.wallet.withdraw_ms.infra.interfaces.repository.WithdrawRepositoryInterface
import com.wallet.withdraw_ms.infra.interfaces.service.MessageServiceInterface
import com.wallet.withdraw_ms.infra.interfaces.service.WithdrawServiceInterface
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class WithdrawService(
    val withdrawRepositoryInterface: WithdrawRepositoryInterface,
    val messageServiceInterface: MessageServiceInterface
): WithdrawServiceInterface {

    private final val topic = "transactions"

    override fun create(dto: WithdrawDto): UUID {
        val registered = withdrawRepositoryInterface.save(Withdraw(null, dto.userId, dto.value))

        try {
            messageServiceInterface.sendMessage(topic, TransactionDto(
                registered.userId, registered.value, TransactionType.WITHDRAW, MovementType.DEBIT)
            )
        }catch (e:Exception){
            println(e)
        }
        return registered.id!!
    }
}



