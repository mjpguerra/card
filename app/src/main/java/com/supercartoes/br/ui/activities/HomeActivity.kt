package com.supercartoes.br.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.superca.HomeFragment
import com.supercartoes.br.R
import com.supercartoes.br.ui.fragments.TransactionDetailFragment
import com.supercartoes.br.ui.utils.showCustomDialog


/**
 * @author Mario Guerra on 10/07/2019
 */

class HomeActivity : AppCompatActivity() {

    lateinit var loader: View
    lateinit var tvLoaderMsg: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loader = findViewById(R.id.loader)
        tvLoaderMsg = findViewById(R.id.tvLoaderMsg)

        mReplaceFragment(HomeFragment.newInstance(), "HomeFragment", true)

    }

    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putBoolean("MyBoolean", true)
    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        val myBoolean = savedInstanceState.getBoolean("MyBoolean")
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

    fun noReceipt() {
        supportFragmentManager.popBackStackImmediate()
        Toast.makeText(this, getString(R.string.transaction_no_receipt), Toast.LENGTH_SHORT).show()
//        showSB(text = getString(R.string.transaction_no_receipt), time = Snackbar.LENGTH_SHORT)
    }

    fun showTransactionDetail(id: Long, type: Long, source: String) {
        val historic = TransactionDetailFragment.newInstance(id, type, source)
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.section, historic, "transactionDetailFragment")
        ft.addToBackStack("")
        ft.commit()
    }

    override fun onBackPressed() {
        showCustomDialog(image = R.drawable.ic_warning, title =
        R.string.dialog_exit_message,
            no = {}, noDismissesDialog = true, yes =
            {
                super.onBackPressed()
                finish()
            })

    }
}

