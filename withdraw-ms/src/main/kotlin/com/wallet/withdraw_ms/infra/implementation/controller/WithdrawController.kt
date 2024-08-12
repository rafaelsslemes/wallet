package com.wallet.withdraw_ms.infra.implementation.controller

import com.wallet.withdraw_ms.infra.dto.WithdrawDto
import com.wallet.withdraw_ms.infra.interfaces.controller.WithdrawControllerInterface
import com.wallet.withdraw_ms.infra.interfaces.service.WithdrawServiceInterface
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("withdraws")
class WithdrawController (
    val withdrawServiceInterface: WithdrawServiceInterface
): WithdrawControllerInterface {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    override fun create(dto: WithdrawDto): UUID {
        val registeredId = withdrawServiceInterface.create(dto)

        return registeredId
    }
}