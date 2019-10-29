package com.supercartoes.br.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.supercartoes.br.R
import com.supercartoes.br.SuperDigitalApplication
import com.supercartoes.br.repository.AppPreferencesRegister
import com.supercartoes.br.ui.fragments.LoginFragment
import com.supercartoes.br.ui.fragments.SMSAuthFragment
import com.supercartoes.br.ui.utils.Const

/**
 * @author Mario Guerra on 10/07/2019
 */

class LoginActivity : AppCompatActivity() {

    private var App = SuperDigitalApplication.initializer
    private lateinit var preferencesRegister: AppPreferencesRegister
    lateinit var loader: View
    lateinit var tvLoaderMsg: TextView

    companion object {
        @SuppressLint("loginActivity")
        lateinit var loginActivity: LoginActivity

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loader = findViewById(R.id.loader)
        tvLoaderMsg = findViewById(R.id.tvLoaderMsg)

        loginActivity = this

        App.initializeLib(this@LoginActivity)
        preferencesRegister = AppPreferencesRegister(this)

        if (preferencesRegister.tokenDevice) {
            mReplaceFragment(LoginFragment.newInstance(), Const.OPEN_ACCOUNT_TWO)
        } else {
            mReplaceFragment(SMSAuthFragment.newInstance(), Const.OPEN_ACCOUNT_ONE)
        }

    }

    fun showLoader(msg: String) {
        tvLoaderMsg.text = msg
        loader.visibility = View.VISIBLE
    }

    fun hideLoader() {
        tvLoaderMsg.text = ""
        loader.visibility = View.GONE
    }

    fun mReplaceFragment(fragment: Fragment, flag: String, animUp: Boolean? = false, addToBackStack: Boolean? = true) {
        val ft = supportFragmentManager.beginTransaction()
        if (animUp!!) {
            ft.setCustomAnimations(
                R.anim.slide_in_from_bottom,
                R.anim.slide_out_up,
                R.anim.slide_in_from_top,
                R.anim.slide_out_from_bottom
            )
        } else {
            ft.setCustomAnimations(
                R.anim.slide_in_fromright,
                R.anim.slide_out_toleft,
                R.anim.slide_in_fromleft,
                R.anim.slide_out_toright
            )
        }
        ft.replace(R.id.navContainer, fragment, flag)
        if (addToBackStack!!)
            ft.addToBackStack("")
        ft.commitAllowingStateLoss()
    }

    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onBackPressed() {
        if (!preferencesRegister.numberCardState)
            preferencesRegister.saveNumberCard("")

        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStackImmediate()
        } else {
            finishAffinity()
        }
    }


}