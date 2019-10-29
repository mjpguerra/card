package com.supercartoes.br.ui.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.supercartoes.br.R
import com.supercartoes.br.repository.AppPreferencesRegister
import com.supercartoes.br.ui.activities.LoginActivity
import com.supercartoes.br.ui.utils.Const
import com.supercartoes.br.ui.utils.addButtonAnimation
import com.supercartoes.br.ui.utils.showSB
import com.supercartoes.br.utils.Mask
import com.supercartoes.br.utils.SystemUtil.hideKeyboard
import layout.superdigital.com.superdigitallayout.animator.CentralAnimator
import superdigital.com.superdigitalotp.callbacks.SuperdigitalCallback
import superdigital.com.superdigitalotp.main.SuperDigital
import superdigital.com.superdigitalotp.operations.OperationRequestAuthCode
import superdigital.com.superdigitalotp.operations.responses.ResponseDefault
import superdigital.com.superdigitalotp.repository.models.Error
import superdigital.com.superdigitalotp.utils.DebugSuperdigital

/**
 * @author Mario Guerra on 10/07/2019
 */

class SMSAuthFragment : Fragment() {

    private lateinit var etPhoneNumber: EditText
    private lateinit var btnGo: Button
    private lateinit var mView: View
    private lateinit var tvLoaderMsg: TextView
    private lateinit var preferencesRegister: AppPreferencesRegister

    private lateinit var loader: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferencesRegister = AppPreferencesRegister(activity)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.fragment_sms_auth, container, false)
        initWidgets(mView)
        return mView
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (activity == null)
            return
    }

    override fun onResume() {
        super.onResume()
        etPhoneNumber.addTextChangedListener(Mask.mask("(##) #####-####"))
        hideKeyboard((this@SMSAuthFragment.activity as LoginActivity), mView)
    }

    private fun initWidgets(view: View) {

        btnGo = view.findViewById(R.id.btnSignIn)
        etPhoneNumber = view.findViewById(R.id.etNumberPhone)
        tvLoaderMsg = view.findViewById(R.id.tvLoaderMsg)
        loader = view.findViewById(R.id.loader)

        btnGo.addButtonAnimation()
        btnGo.setOnClickListener {
            validatePhone()
        }

        etPhoneNumber.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                hideKeyboard((this@SMSAuthFragment.activity as LoginActivity), mView)
            }
            false
        }
    }

    private fun callToken(phone: String) {
        hideKeyboard(this@SMSAuthFragment.activity as LoginActivity, mView)
        showLoader(getString(R.string.validating_phone))

        SuperDigital.Builder((this@SMSAuthFragment.activity as LoginActivity))
            .operation(OperationRequestAuthCode(SuperDigital.SubjectAuthenticate.PRE_REGISTER.code, SuperDigital.AuthType.SMS, phone, false))
            .enqueue(object : SuperdigitalCallback<ResponseDefault> {
                override fun onFailure(error: Error) {
                        activity?.showSB(
                            if (error.messages.isNotEmpty()) error.messages[0] else getString(R.string.generic_error2),
                            time = Toast.LENGTH_SHORT
                        )
                        DebugSuperdigital.Log.e("ERROR", "Error: ${error.messages}")
                        hideLoader()
                }

                override fun onSuccess(response: ResponseDefault) {

                    preferencesRegister.saveNumberPhone(phone)

                    (activity as LoginActivity).mReplaceFragment(
                        TokenValidationFragment.newInstance(),
                        Const.OPEN_ACCOUNT_TWO,
                        false
                    )
                    hideLoader()
                }
            })
    }

    private fun validatePhone() {
        val p = Mask.unmask(etPhoneNumber.text.toString(), "(##) #####-####")
        if (p.length >= 11) {
            callToken(p)
        } else {
            CentralAnimator.startAnimatorError(mView)
            etPhoneNumber.error = resources.getString(R.string.phone_error)
        }
    }


    private fun showLoader(msg: String) {
        tvLoaderMsg.text = msg
        loader.visibility = View.VISIBLE
    }

    fun hideLoader() {
        loader.visibility = View.GONE
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            SMSAuthFragment().apply {}
    }
}
