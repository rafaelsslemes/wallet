package com.wallet.deposit_ms.infra.implementation.service

import com.wallet.deposit_ms.entity.Deposit
import com.wallet.deposit_ms.infra.dto.DepositDto
import com.wallet.deposit_ms.infra.interfaces.repository.DepositRepositoryInterface
import com.wallet.deposit_ms.infra.interfaces.service.DepositServiceInterface
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DepositService(
    val depositRepositoryInterface: DepositRepositoryInterface
): DepositServiceInterface {

    override fun create(dto: DepositDto): UUID {
        val registered = depositRepositoryInterface.save(Deposit(null, dto.userId, dto.value))
        return registered.id!!
    }

}
