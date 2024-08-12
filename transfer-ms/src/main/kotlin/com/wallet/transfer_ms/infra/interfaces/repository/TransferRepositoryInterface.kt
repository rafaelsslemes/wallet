package com.wallet.transfer_ms.infra.interfaces.repository

import com.wallet.transfer_ms.entity.Transfer
import org.springframework.data.repository.CrudRepository
import java.util.*

interface TransferRepositoryInterface: CrudRepository<Transfer, UUID> {
}