package com.wallet.deposit_ms.infra.interfaces.controller

import com.wallet.deposit_ms.infra.dto.DepositDto
import java.util.*

interface DepositControllerInterface {
    fun create(dto: DepositDto): UUID
}