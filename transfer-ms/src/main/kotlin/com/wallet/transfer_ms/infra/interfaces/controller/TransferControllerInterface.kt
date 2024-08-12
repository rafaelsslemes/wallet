package com.wallet.transfer_ms.infra.interfaces.controller

import com.wallet.transfer_ms.infra.dto.TransferDto
import java.util.*

interface TransferControllerInterface {
    fun create(dto: TransferDto): UUID
}