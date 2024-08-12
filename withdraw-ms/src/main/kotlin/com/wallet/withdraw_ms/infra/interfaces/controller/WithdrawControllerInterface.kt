package com.wallet.withdraw_ms.infra.interfaces.controller

import com.wallet.withdraw_ms.infra.dto.WithdrawDto
import java.util.*

interface WithdrawControllerInterface {
    fun create(dto: WithdrawDto): UUID
}