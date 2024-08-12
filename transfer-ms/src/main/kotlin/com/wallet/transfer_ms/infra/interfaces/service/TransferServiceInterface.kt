package com.wallet.transfer_ms.infra.interfaces.service

import com.wallet.transfer_ms.infra.dto.TransferDto
import java.util.UUID

interface TransferServiceInterface {

    fun create(dto: TransferDto): UUID

}
