package com.wallet.deposit_ms.infra.interfaces.service

import com.wallet.deposit_ms.infra.dto.DepositDto
import java.util.UUID

interface DepositServiceInterface {

    fun create(dto: DepositDto): UUID

}
