package com.wallet.account_ms.infra.implementation.service

import com.wallet.account_ms.entity.User
import com.wallet.account_ms.infra.dto.UserDto
import com.wallet.account_ms.infra.interfaces.repository.UserRepositoryInterface
import com.wallet.account_ms.infra.interfaces.service.BalanceServiceInterface
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.Optional
import java.util.UUID

@ExtendWith(MockKExtension::class)
class UserServiceTest{

@MockK
private lateinit var  userRepositoryInterface: UserRepositoryInterface

@MockK
private lateinit var  balanceServiceInterface: BalanceServiceInterface

@InjectMockKs
private lateinit var userService: UserService

@Test
fun `should create User`() {
  val mockUser = buildUser()
  every { userRepositoryInterface.save(any()) } returns mockUser
  every { balanceServiceInterface.create(any()) } returns mockUser.id!!


  val userId = userService.create(UserDto(null, "Fake", "12345678910"))

  assertEquals(userId, mockUser.id)
}

@Test
fun `should update User`() {
  val mockUser = buildUser()
  val updatedMockUser = mockUser.copy()
  updatedMockUser.document = "00000000000"

  every { userRepositoryInterface.findById(any()) } returns Optional.of(mockUser)
  every { userRepositoryInterface.save(any()) } returns updatedMockUser

  val userId = userService.update(UserDto(mockUser.id, "Fake", "12345678910"))

  assertEquals(mockUser.id, userId)
  verify(exactly = 1) { userRepositoryInterface.save(any()) }

}

  @Test
  fun `should get User`() {
    val mockUser = buildUser()

    every { userRepositoryInterface.findById(any()) } returns Optional.of(mockUser)

    val user = userService.get(mockUser.id.toString())

    assertEquals(user, mockUser)
  }

private fun buildUser() = User(UUID.randomUUID(), "Fake Name", "fakeDocument")

}