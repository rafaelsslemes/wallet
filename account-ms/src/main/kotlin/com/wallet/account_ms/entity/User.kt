package com.wallet.account_ms.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
data class User (

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    var id: UUID?,

    var fullname: String,
    var document: String,
) {}