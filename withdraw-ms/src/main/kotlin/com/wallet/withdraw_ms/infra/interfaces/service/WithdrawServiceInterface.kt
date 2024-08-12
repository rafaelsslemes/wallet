package com.wallet.withdraw_ms.infra.interfaces.service

import com.wallet.withdraw_ms.infra.dto.WithdrawDto
import java.util.UUID

interface WithdrawServiceInterface {

    fun create(dto: WithdrawDto): UUID

}
