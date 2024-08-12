package com.wallet.account_ms.infra.implementation.service

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.wallet.account_ms.infra.dto.TransactionDto
import com.wallet.account_ms.infra.interfaces.service.BalanceServiceInterface
import com.wallet.account_ms.infra.interfaces.service.MessageConsumerServiceInterface
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

const val TOPIC: String = "transactions"
const val GROUPID: String = "account-ms"

@Service
class MessageConsumerService (
    balanceServiceInterface: BalanceServiceInterface
) : MessageConsumerServiceInterface {

    companion object {
        private val LOGGER : Logger = LoggerFactory.getLogger(KafkaConsumer::class.java)
    }

    @Autowired
    private lateinit var balanceServiceInterface: BalanceServiceInterface


    @KafkaListener(topics = [TOPIC], groupId = GROUPID)
    override fun listen(message: String) {
        val gson = Gson()
        val transactionJson = JsonParser.parseString(message)
        val transaction = gson.fromJson(transactionJson, TransactionDto::class.java)

        balanceServiceInterface.updateValue(transaction)
        LOGGER.info(transaction.toString())
    }

}