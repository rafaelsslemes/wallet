package com.wallet.account_ms.infra.interfaces.service

import com.wallet.account_ms.entity.User
import com.wallet.account_ms.infra.dto.UserDto
import java.util.UUID

interface UserServiceInterface {

    fun create(dto: UserDto) : UUID
    fun update(dto: UserDto): UUID
    fun get(id: String): User

}