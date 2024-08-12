package com.wallet.deposit_ms.infra.interfaces.service


interface MessageServiceInterface  {
    fun sendMessage(topic : String, obj : Any)
}