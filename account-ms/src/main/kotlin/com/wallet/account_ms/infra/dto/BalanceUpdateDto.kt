package com.wallet.account_ms.infra.dto

import java.util.UUID

class BalanceUpdateDto (
    val userId: UUID,
    val transactionType: TransactionType,
    val value: Double){
}