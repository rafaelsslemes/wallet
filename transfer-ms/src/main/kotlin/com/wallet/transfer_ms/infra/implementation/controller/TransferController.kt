package com.wallet.transfer_ms.infra.implementation.controller

import com.wallet.transfer_ms.infra.dto.TransferDto
import com.wallet.transfer_ms.infra.interfaces.controller.TransferControllerInterface
import com.wallet.transfer_ms.infra.interfaces.service.TransferServiceInterface
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("transfers")
class TransferController (
    val transferServiceInterface: TransferServiceInterface
): TransferControllerInterface {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    override fun create(dto: TransferDto): UUID {
        val registeredId = transferServiceInterface.create(dto)

        return registeredId
    }
}