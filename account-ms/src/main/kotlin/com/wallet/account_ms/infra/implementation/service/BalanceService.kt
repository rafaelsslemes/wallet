package com.wallet.account_ms.infra.implementation.service

import com.wallet.account_ms.entity.Balance
import com.wallet.account_ms.entity.User
import com.wallet.account_ms.infra.dto.MovementType
import com.wallet.account_ms.infra.dto.TransactionDto
import com.wallet.account_ms.infra.dto.TransactionType
import com.wallet.account_ms.infra.exception.BalanceNotFoundException
import com.wallet.account_ms.infra.exception.UserNotFoundException
import com.wallet.account_ms.infra.interfaces.repository.BalanceRepositoryInterface
import com.wallet.account_ms.infra.interfaces.service.BalanceServiceInterface
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class BalanceService(val balanceRepositoryInterface: BalanceRepositoryInterface): BalanceServiceInterface {

    override fun create(user: User): UUID {
        val balance = Balance(user.id,  user, value = 0.0)
        val registered = balanceRepositoryInterface.save(balance)

        return registered.id!!

    }

    override fun updateValue(dto: TransactionDto): Double {
        val balance = balanceRepositoryInterface.findById(dto.userId).orElseThrow{UserNotFoundException("BALANCE_NOT_FOUND")}

        when(dto.movementType) {
            MovementType.CREDIT -> balance.value += dto.value
            MovementType.DEBIT -> balance.value -= dto.value
        }

        val updated = balanceRepositoryInterface.save(balance)
        return updated.value
    }

    override fun get(userId: UUID): Balance {
        return balanceRepositoryInterface.findById(userId).orElseThrow { BalanceNotFoundException("BALANCE_NOT_FOUND") }
    }

}