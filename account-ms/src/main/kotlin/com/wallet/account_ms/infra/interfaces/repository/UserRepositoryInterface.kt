package com.wallet.account_ms.infra.interfaces.repository

import com.wallet.account_ms.entity.User
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepositoryInterface: CrudRepository<User, UUID> {
}