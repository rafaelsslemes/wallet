package com.wallet.account_ms.infra.interfaces.service

import com.wallet.account_ms.entity.Balance
import com.wallet.account_ms.entity.User
import com.wallet.account_ms.infra.dto.TransactionDto
import java.util.UUID

interface BalanceServiceInterface {

    fun create(user: User) : UUID
    fun updateValue(dto: TransactionDto): Double
    fun get(userId: UUID): Balance

}