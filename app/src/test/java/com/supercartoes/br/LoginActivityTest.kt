package com.supercartoes.br

import com.supercartoes.br.LoginActivityTest.LoginRepository.Companion.CORRECT_LOGIN
import com.supercartoes.br.LoginActivityTest.LoginRepository.Companion.CORRECT_PASSWORD
import io.reactivex.Observable
import io.reactivex.Observable.fromCallable
import org.junit.Test
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class LoginActivityTest {

    val objectUnderTest = LoginRepository()

    @Test
    fun `login with correct login and password`() {

        //given
        val correctLogin = CORRECT_LOGIN
        val correctPassword = CORRECT_PASSWORD
        //when
        val result = objectUnderTest.login(correctLogin, correctPassword)
        //then
        result.test().await()
            .assertResult(true)

    }

    @Test
    fun `do not login with only correct login`() {
        //given
        val login = CORRECT_LOGIN
        val password = "anyPassword"
        //when
        val result = objectUnderTest.login(login, password)
        //then
        result.test().await().assertResult(false)
    }

    @Test
    fun `do not login with only correct password`() {
        //given
        val login = "anyLogin"
        val password = CORRECT_PASSWORD
        //when
        val result = objectUnderTest.login(login, password)
        //then
        result.test().await()
            .assertResult(false)
    }

    class LoginRepository {

        fun login(login: String, password: String): Observable<Boolean> {
            Timber.v("login %s with password %s", login, password)

            return fromCallable { CORRECT_LOGIN == login && CORRECT_PASSWORD == password }
                .delay(2000, TimeUnit.MILLISECONDS)
        }

        companion object {
            internal val CORRECT_LOGIN = "5276600057108881"
            internal val CORRECT_PASSWORD = "1234"
        }
    }
}
