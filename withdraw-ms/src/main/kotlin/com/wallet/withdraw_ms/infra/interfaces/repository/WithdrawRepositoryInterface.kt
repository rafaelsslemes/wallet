package com.wallet.withdraw_ms.infra.interfaces.repository

import com.wallet.withdraw_ms.entity.Withdraw
import org.springframework.data.repository.CrudRepository
import java.util.*

interface WithdrawRepositoryInterface: CrudRepository<Withdraw, UUID> {
}