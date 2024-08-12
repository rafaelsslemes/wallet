package com.wallet.transfer_ms.infra.dto

import java.util.*

class TransferDto (val payerUserId: UUID, val receiverUserId: UUID, val value: Double){}