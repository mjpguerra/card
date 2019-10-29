package com.supercartoes.br.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.supercartoes.br.R
import com.supercartoes.br.ui.customs.FingerprintDialog
import com.supercartoes.br.ui.fragments.PasswordCardFragment

/**
 * @author Mario Guerra on 10/07/2019
 */

class PasswordActivity : AppCompatActivity() {

    lateinit var tvError: TextView
    lateinit var loader: View
    lateinit var tvLoaderMsg: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_token)

        loader = findViewById(R.id.loader)
        tvLoaderMsg = findViewById(R.id.tvLoaderMsg)

        mReplaceFragment(PasswordCardFragment.newInstance(), "cardPass", true)

    }

    fun mReplaceFragment(fragment: Fragment, flag: String, animUp: Boolean) {
        val ft = supportFragmentManager.beginTransaction()
        if (animUp) {
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
        ft.replace(R.id.section, fragment, flag)
        ft.addToBackStack("")
        ft.commitAllowingStateLoss()
    }


    fun showLoader(msg: String) {
        tvLoaderMsg.text = msg
        loader.visibility = View.VISIBLE
    }

    fun hideLoader() {
        tvLoaderMsg.text = ""
        loader.visibility = View.GONE
    }

    fun showError(error: String) {
        tvError.text = error
        tvError.visibility = View.VISIBLE
    }

    fun hideError() {
        tvError.text = ""
        tvError.visibility = View.GONE
    }

    override fun onBackPressed() {
        startActivity(
            Intent(this, LoginActivity::class.java).setFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK))
        finish()
    }


    fun actLibLogin(pass: String) {
        val loginTwo = supportFragmentManager.findFragmentByTag("cardPass")
          if (loginTwo != null) {
            (loginTwo as PasswordCardFragment).libLogin(pass)
        }
    }

    fun dialogFragmentShow(dialogFragment: FingerprintDialog, flag: String) {
        dialogFragment.isCancelable = false
        dialogFragment.show(supportFragmentManager, flag)
    }
}

