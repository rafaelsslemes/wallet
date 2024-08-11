package com.wallet.account_ms.infra.implementation.service

import com.wallet.account_ms.entity.User
import com.wallet.account_ms.infra.dto.UserDto
import com.wallet.account_ms.infra.exception.BadRequestException
import com.wallet.account_ms.infra.exception.UserNotFoundException
import com.wallet.account_ms.infra.interfaces.repository.UserRepositoryInterface
import com.wallet.account_ms.infra.interfaces.service.BalanceServiceInterface
import com.wallet.account_ms.infra.interfaces.service.UserServiceInterface
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(
    val userRepositoryInterface: UserRepositoryInterface,
    val balanceServiceInterface: BalanceServiceInterface
): UserServiceInterface {

    override fun create(dto: UserDto): UUID {
        val user = User(null, dto.name, dto.document)
        val registered = userRepositoryInterface.save(user)

        balanceServiceInterface.create(registered)

        return registered.id!!
    }

    override fun update(dto: UserDto): UUID {

        dto.id ?: throw BadRequestException("ID_NOT_SET")

        val user = userRepositoryInterface.findById(dto.id).orElseThrow{UserNotFoundException("USER_NOT_FOUND")}
        user.fullname = dto.name
        user.document = dto.document

        val updated = userRepositoryInterface.save(user)

        return updated.id!!
    }

    override fun get(id: String): User {
        try {
            val uuid = UUID.fromString(id)
            val user = userRepositoryInterface.findById(uuid).orElseThrow { UserNotFoundException("USER_NOT_FOUND") }
            return user
        } catch (error: IllegalArgumentException){
            throw BadRequestException("INVALID_UUID")
        }
    }

}