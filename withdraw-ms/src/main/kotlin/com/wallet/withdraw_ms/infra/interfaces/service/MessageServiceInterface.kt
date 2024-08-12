package com.wallet.withdraw_ms.infra.interfaces.service


interface MessageServiceInterface  {
    fun sendMessage(topic : String, obj : Any)
}