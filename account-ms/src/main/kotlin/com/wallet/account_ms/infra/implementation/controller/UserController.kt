package com.wallet.account_ms.infra.implementation.controller

import com.wallet.account_ms.entity.User
import com.wallet.account_ms.infra.dto.UserDto
import com.wallet.account_ms.infra.interfaces.controller.UserControllerInterface
import com.wallet.account_ms.infra.interfaces.service.UserServiceInterface
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("users")
class UserController(
    val userService : UserServiceInterface
): UserControllerInterface {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    override fun get(@RequestParam id: String): User {
        return userService.get(id)

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    override fun create(@RequestBody dto: UserDto): UUID {
        val registeredId = userService.create(dto)
        return registeredId

    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    override fun update(@RequestBody dto: UserDto): UUID {
        val id = userService.update(dto)
        return id

    }
}