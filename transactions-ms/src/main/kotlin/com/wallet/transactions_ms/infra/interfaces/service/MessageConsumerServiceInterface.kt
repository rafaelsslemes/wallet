package com.wallet.transactions_ms.infra.interfaces.service

interface MessageConsumerServiceInterface {
    fun listen(message: String)
}