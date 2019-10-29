package com.supercartoes.br.ui.fragments

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SwitchCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.supercartoes.br.R
import com.supercartoes.br.repository.AppPreferencesRegister
import com.supercartoes.br.ui.activities.LoginActivity
import com.supercartoes.br.ui.activities.PasswordActivity
import com.supercartoes.br.ui.utils.*
import com.supercartoes.br.utils.Mask
import com.supercartoes.br.utils.SystemUtil


private const val ARG_PARAM1 = "param1"

class LoginFragment : Fragment() {
    private lateinit var mView: View
    private var param1: String? = null
    private lateinit var etNumberCard: EditText
    private lateinit var btnSignIn: Button
    lateinit var etPassword: TextInputEditText
    private lateinit var preferencesRegister: AppPreferencesRegister
    private lateinit var swRememberNumber: SwitchCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferencesRegister = AppPreferencesRegister(activity)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.fragment_login, container, false)
        initWidgets(mView)
        return mView
    }

    override fun onStart() {
        super.onStart()
        if(SDUtil.error != null){
            if(SDUtil.error!!.code == 401){
                activity?.showSB(
                    if (SDUtil.error!!.messages.isNotEmpty()) SDUtil.error!!.messages[0] else getString(R.string.generic_error2),
                    time = Toast.LENGTH_SHORT
                )
            }
        }
    }

    private fun initWidgets(view: View) {

        btnSignIn = view.findViewById(R.id.btnSignIn)
        etNumberCard = view.findViewById(R.id.etNumberCard)
        etPassword = view.findViewById(R.id.etPassword)
        swRememberNumber = view.run { findViewById(R.id.swRememberNumber) }

        swRememberNumber.isChecked = preferencesRegister.numberCardState

        if (preferencesRegister.numberCardState) {
            etNumberCard.addTextChangedListener(Mask.mask("**** **** **** ####"))
            etNumberCard.setText(preferencesRegister.numberCard!!.substring(12))
            etNumberCard.isEnabled = false
            etNumberCard.isFocusable = false
        } else {
            etNumberCard.addTextChangedListener(Mask.mask("#### #### #### ####"))
            etNumberCard.setText(preferencesRegister.numberCard!!)
            etNumberCard.setSelection(etNumberCard.length())
            etNumberCard.isFocusable = true
            etNumberCard.isEnabled = true
        }

        etNumberCard.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (preferencesRegister.numberCardState) {
                    if (preferencesRegister.numberCard != s) {
                        preferencesRegister.saveNumberCardState(false)
                        preferencesRegister.saveNumberCard("")
                        swRememberNumber.isChecked = false
                    }
                }
            }
        })
        btnSignIn.addButtonAnimation()

        etPassword.setOnClickListener {
            goPassword()
        }

        btnSignIn.setOnClickListener {
            goPassword()
        }

        swRememberNumber.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                if (preferencesRegister.numberCardState) {
                    (activity as LoginActivity).showCustomDialog(
                        R.drawable.ic_warning,
                        R.string.attention,
                        R.string.remember_cpf_dialog, {

                            preferencesRegister.saveNumberCard("")
                            preferencesRegister.saveNumberCardState(isChecked)

                            val fm = activity!!.supportFragmentManager
                            for (i in 0 until fm.backStackEntryCount) {
                                fm.popBackStackImmediate()
                            }

                            (activity as LoginActivity).mReplaceFragment(newInstance(), Const.OPEN_ACCOUNT_TWO, false)

                        }, { swRememberNumber.isChecked = !isChecked },
                        R.string.yes,
                        R.string.no,
                        yesDismissesDialog = true,
                        noDismissesDialog = true,
                        dismissOutside = false
                    )
                }
            }else{
                preferencesRegister.saveNumberCardState(isChecked)

                if (preferencesRegister.numberCard.isNullOrEmpty())
                    preferencesRegister.saveNumberCard(etNumberCard.text.toString().replace(" ", ""))

            }
        }
    }


    fun goPassword(){

        if(etNumberCard.text.toString().replace(" ", "").length == 16) {
            preferencesRegister.saveNumberCardState(swRememberNumber.isChecked)

            if (preferencesRegister.numberCard.isNullOrEmpty())
                preferencesRegister.saveNumberCard(etNumberCard.text.toString().replace(" ", ""))

            if (!preferencesRegister.numberCardState)
                if (!preferencesRegister.numberCard.isNullOrEmpty() && preferencesRegister.numberCard != etNumberCard.text.toString())
                    preferencesRegister.saveNumberCard(etNumberCard.text.toString().replace(" ", ""))


            startActivity(
                Intent((this@LoginFragment.activity as LoginActivity), PasswordActivity::class.java).setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK
                )
            )

            (this@LoginFragment.activity as LoginActivity).finish()
        }else{
            activity!!.showSB("Favor digitar um número de cartão com 16 dígitos.", time = Toast.LENGTH_SHORT
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment().apply {}
    }
}
