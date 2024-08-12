package com.wallet.deposit_ms.infra.interfaces.repository

import com.wallet.deposit_ms.entity.Deposit
import org.springframework.data.repository.CrudRepository
import java.util.*

interface DepositRepositoryInterface: CrudRepository<Deposit, UUID> {
}