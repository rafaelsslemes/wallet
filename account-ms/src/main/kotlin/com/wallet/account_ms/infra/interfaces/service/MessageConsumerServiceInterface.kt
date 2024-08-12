package com.wallet.account_ms.infra.interfaces.service

interface MessageConsumerServiceInterface {
    fun listen(message: String)
}