package com.wallet.account_ms.infra.implementation.controller

import com.wallet.account_ms.entity.Balance
import com.wallet.account_ms.infra.dto.BalanceUpdateDto
import com.wallet.account_ms.infra.interfaces.controller.BalanceControllerInterface
import com.wallet.account_ms.infra.interfaces.service.BalanceServiceInterface
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("balance")
class BalanceController(
    val balanceServiceInterface: BalanceServiceInterface
): BalanceControllerInterface {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    override fun get(userId: UUID): Balance {
        return balanceServiceInterface.get(userId)
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    override fun updateValue(dto: BalanceUpdateDto): Double {
       return balanceServiceInterface.updateValue(dto)
    }
}