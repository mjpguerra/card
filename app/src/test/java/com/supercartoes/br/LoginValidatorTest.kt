package com.supercartoes.br


import org.junit.Test
import org.assertj.core.api.Assertions.assertThat

class LoginValidatorTest {


    private val objectUnderTest = LoginValidator()

    @Test
    fun `empty login is invalid`() {
        //when
        val result = objectUnderTest.validateLogin("")
        //then
        assertThat(result).isFalse()
    }

    @Test
    fun `not empty login is valid`() {
        //when
        val result = objectUnderTest.validateLogin("anyLogin")
        //then
        assertThat(result).isTrue()
    }

    @Test
    fun `empty password is invalid`() {
        //when
        val result = objectUnderTest.validatePassword("")
        //then
        assertThat(result).isFalse()
    }

    @Test
    fun `password is invalid if shorter then limit`() {
        //when
        val result = objectUnderTest.validatePassword("123")
        //then
        assertThat(result).isFalse()
    }

    @Test
    fun `password is valid if equal to limit`() {
        //when
        val result = objectUnderTest.validatePassword("1234")
        //then
        assertThat(result).isTrue()
    }

    @Test
    fun `password is valid if longer than limit`() {
        //when
        val result = objectUnderTest.validatePassword("12345")
        //then
        assertThat(result).isTrue()
    }


    class LoginValidator {

        companion object {
            val EMPTY = ""
            val MIN_PASSWORD_LENGTH = 4
        }

        fun validateLogin(login: String): Boolean {
            return login != EMPTY
        }

        fun validatePassword(password: String): Boolean {
            return password.length >= MIN_PASSWORD_LENGTH
        }
    }
}