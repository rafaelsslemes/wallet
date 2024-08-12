package com.wallet.account_ms.infra.interfaces.controller

import com.wallet.account_ms.entity.Balance
import com.wallet.account_ms.infra.dto.TransactionDto
import java.util.*

interface BalanceControllerInterface {

    fun get(userId: UUID): Balance
    fun updateValue(dto: TransactionDto): Double

}