package com.wallet.account_ms.infra.interfaces.repository

import com.wallet.account_ms.entity.Balance
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface BalanceRepositoryInterface: CrudRepository<Balance, UUID> {
}