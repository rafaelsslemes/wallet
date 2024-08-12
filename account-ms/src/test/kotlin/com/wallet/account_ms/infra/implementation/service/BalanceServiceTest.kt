package com.wallet.account_ms.infra.implementation.service

import com.wallet.account_ms.entity.Balance
import com.wallet.account_ms.entity.User
import com.wallet.account_ms.infra.dto.MovementType
import com.wallet.account_ms.infra.dto.TransactionDto
import com.wallet.account_ms.infra.dto.TransactionType
import com.wallet.account_ms.infra.interfaces.repository.BalanceRepositoryInterface
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.Instant
import java.util.*

@ExtendWith(MockKExtension::class)

class BalanceServiceTest{

    @MockK
    private lateinit var  balanceRepositoryInterface: BalanceRepositoryInterface

    @InjectMockKs
    private lateinit var balanceService: BalanceService

    @Test
    fun `should create Balance`() {
        val mockUser = buildUser()
        val mockBalance = buildBalance(mockUser.id!!)
        every { balanceRepositoryInterface.save(any()) } returns mockBalance

        val balanceId = balanceService.create(mockUser)
        assertEquals(mockBalance.id, balanceId)
        verify(exactly = 1) { balanceRepositoryInterface.save(any()) }

    }

    @Test
    fun `should get Balance`() {
        val mockUser = buildUser()
        val mockBalance = buildBalance(mockUser.id!!)
        every { balanceRepositoryInterface.findById(any()) } returns Optional.of(mockBalance)

        val balance = balanceService.get(mockUser.id!!)

        assertEquals(mockBalance, balance)
        verify(exactly = 1) { balanceRepositoryInterface.findById(any()) }
    }

    @Test
    fun `should update value`() {

        val mockUser = buildUser()
        val mockBalance = buildBalance(mockUser.id!!)
        val updated = mockBalance.copy()
        updated.value += 200.0

        every { balanceRepositoryInterface.findById(any()) } returns Optional.of(mockBalance)
        every { balanceRepositoryInterface.save(any()) } returns updated

        val updatedBalance = balanceService.updateValue(
            TransactionDto(mockUser.id!!, 100.0, TransactionType.DEPOSIT, MovementType.CREDIT)
        )
        assertNotEquals(mockBalance.value, updatedBalance)
    }

    private fun buildBalance(id: UUID): Balance {
        return Balance(id, User(id, "Fake", "00000"), 0.0)}

    private fun buildUser() = User(UUID.randomUUID(), "Fake Name", "fakeDocument")

}