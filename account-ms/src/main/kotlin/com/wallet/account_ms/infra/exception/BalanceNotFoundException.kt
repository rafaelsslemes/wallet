package com.wallet.account_ms.infra.exception

class BalanceNotFoundException (override val message: String) : Exception() {}