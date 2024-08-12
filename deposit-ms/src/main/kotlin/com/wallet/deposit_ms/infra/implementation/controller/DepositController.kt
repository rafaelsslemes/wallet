package com.wallet.deposit_ms.infra.implementation.controller

import com.wallet.deposit_ms.infra.dto.DepositDto
import com.wallet.deposit_ms.infra.interfaces.controller.DepositControllerInterface
import com.wallet.deposit_ms.infra.interfaces.service.DepositServiceInterface
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("deposits")
class DepositController (
    val depositServiceInterface: DepositServiceInterface
): DepositControllerInterface {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    override fun create(dto: DepositDto): UUID {
        val registeredId = depositServiceInterface.create(dto)

        return registeredId
    }
}