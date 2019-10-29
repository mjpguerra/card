package com.supercartoes.br.ui.fragments

import android.app.Activity
import android.app.KeyguardManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.hardware.fingerprint.FingerprintManagerCompat
import androidx.fragment.app.Fragment
import com.supercartoes.br.R
import com.supercartoes.br.repository.AppPreferencesRegister
import com.supercartoes.br.ui.activities.HomeActivity
import com.supercartoes.br.ui.activities.LoginActivity
import com.supercartoes.br.ui.activities.PasswordActivity
import com.supercartoes.br.ui.customs.FingerprintDialog
import com.supercartoes.br.ui.utils.customizeToolbar
import com.supercartoes.br.ui.utils.showCustomDialog
import com.supercartoes.br.ui.utils.showSB
import com.supercartoes.br.utils.SystemUtil.hideKeyboard
import kotlinx.android.synthetic.main.fragment_password_token.view.*
import superdigital.com.superdigitalotp.callbacks.SuperdigitalCallback
import superdigital.com.superdigitalotp.main.SuperDigital
import superdigital.com.superdigitalotp.operations.OperationCardAuth
import superdigital.com.superdigitalotp.operations.OperationSavePassword
import superdigital.com.superdigitalotp.operations.requests.RequestSavePassword
import superdigital.com.superdigitalotp.operations.responses.ResponseCardAuth
import superdigital.com.superdigitalotp.operations.responses.ResponseDefault
import superdigital.com.superdigitalotp.repository.models.Error
import superdigital.com.superdigitalotp.utils.DebugSuperdigital


class PasswordCardFragment : Fragment(), PasswordComponentFragment.OnFragmentPasswordListener {


    private lateinit var preferencesRegister: AppPreferencesRegister
    private lateinit var fingerprintManager: FingerprintManagerCompat
    private lateinit var llContainerForComponentPassword: FrameLayout
    private lateinit var mView: View
    lateinit var etPassword: EditText
    private lateinit var tvFingerPrint: TextView
    private lateinit var tvForgotPassword: TextView
    lateinit var numberCard: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferencesRegister = AppPreferencesRegister(activity)

        numberCard = preferencesRegister.numberCard

        fingerprintManager = FingerprintManagerCompat.from(context!!)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mView = inflater.inflate(R.layout.fragment_password_token, container, false)
        tvFingerPrint = mView.findViewById(R.id.tvFingerPrint)
        llContainerForComponentPassword = mView.findViewById(R.id.flContainerPassword)


        mView.toolbar.customizeToolbar(R.string.title_white, {

            startActivity(
                Intent((this@PasswordCardFragment.activity as PasswordActivity), LoginActivity::class.java).setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK
                )
            )

            this@PasswordCardFragment.activity?.finish()
        })

        if (context != null) {
            val fragmentPassword = PasswordComponentFragment.newInstance("", 4)
            fragmentPassword.setListener(this)
            fragmentManager?.beginTransaction()
                ?.add(mView.flContainerPassword.id, fragmentPassword, "PASSWORD")
                ?.commit()
        }

        tvFingerPrint.setOnClickListener {
            initiFingerprintDialog()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (preferencesRegister.numberCard == numberCard) {

                if (preferencesRegister.passwordFour != "") {
                    savePass(preferencesRegister.passwordFour)
                } else {
                    initFp()
                }
            } else {
                preferencesRegister.saveShowTouchID(true)
                preferencesRegister.saveNumberCard("")
                preferencesRegister.setHasPass(false)
            }
        }

        return mView
    }

    override fun onCharacterPasswordFragmentPassword(password: String, etPassword: EditText) {
        Log.i("TAG", "password: $password")
        this.etPassword = etPassword

        etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s!!.length == 4) {
                    if (validateField(etPassword)) {
                        libLogin(etPassword.text.toString())
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
        addNext()
    }

    fun addNext() {
        if (this::etPassword.isInitialized) {
            etPassword.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    Log.i("TAG", "next clicked ")
                    if (validateField(etPassword)) {
                        libLogin(etPassword.text.toString())
                    }
                }
                false
            }
        }
    }

    private fun validateField(etPassword: EditText): Boolean {
        val valueField = etPassword.text.toString()
        if (valueField.isEmpty() || valueField.length < resources.getInteger(R.integer.pin_quantity)) {
            return false
        }
        return true
    }


    fun libLogin(password: String) {

        val act = (activity as PasswordActivity)

        removeNext()

        act.showLoader(getString(R.string.validating_data))

        SuperDigital.Builder((this@PasswordCardFragment.activity as PasswordActivity))
            .operation(OperationCardAuth(preferencesRegister.numberCard, password))
            .enqueue(object : SuperdigitalCallback<ResponseCardAuth> {
                override fun onFailure(error: Error) {
                    if (activity != null && view != null) {
                        addNext()
                        etPassword.setText("")
                        activity!!.showSB(
                            if (error.messages.isNotEmpty()) error.messages[0] else getString(R.string.generic_error2),
                            time = Toast.LENGTH_SHORT
                        )
                        DebugSuperdigital.Log.e("ERROR", "Error: ${error.messages}")
                        act.hideLoader()
                    }
                }

                override fun onSuccess(response: ResponseCardAuth) {
                    try {
                        act.hideLoader()
                        hideKeyboard(act, mView)



                        addNext()

                        if (preferencesRegister.showTouchID && (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) && fingerprintAvailable()) {
                            (activity as Activity).showCustomDialog(
                                R.drawable.ic_warning,
                                R.string.touch_id,
                                subtitle = R.string.question_use_fingerprint,
                                yesTitle = R.string.yes,
                                noTitle = R.string.no,
                                yes = {
                                    preferencesRegister.saveShowTouchID(false)
//                                                preferencesRegister.savePassword(pass.encrypt(context!!))


                                    savePass(password)
                                },
                                no = {
                                    preferencesRegister.saveShowTouchID(false)

                                    if (!preferencesRegister.numberCardState)
                                        preferencesRegister.saveNumberCard("")

                                    startActivity(
                                        Intent(
                                            act,
                                            HomeActivity::class.java
                                        ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                    )

                                    act.finish()
                                },
                                dismissOutside = false,
                                yesDismissesDialog = true,
                                noDismissesDialog = true
                            )
                        } else {
                            preferencesRegister.saveShowTouchID(false)

                            act.hideLoader()
                            hideKeyboard(act, mView)

                            if (!preferencesRegister.numberCardState)
                                preferencesRegister.saveNumberCard("")

                            startActivity(Intent(act, HomeActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                            act.finish()
                        }


                    } catch (e: Exception) {
                        //   e.logCrashLytics()
                    }

                }
            })
    }


    companion object {
        @JvmStatic
        fun newInstance() = PasswordCardFragment().apply {
        }
    }

    private fun removeNext() {
        if (this::etPassword.isInitialized) {

            etPassword.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                }
                false
            }
        }
    }

    private fun initiFingerprintDialog() {
        val dialogFragment = FingerprintDialog.newInstance(
            "Login",
            getString(R.string.touch_sensor),
            preferencesRegister.numberCard
        )
        (activity as PasswordActivity).dialogFragmentShow(dialogFragment, FingerprintDialog.FRAGMENT_TAG)
    }

    private fun fingerprintAvailable(): Boolean {
        val keyguardManager = activity?.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        return fingerprintManager.isHardwareDetected && fingerprintManager.hasEnrolledFingerprints() && keyguardManager.isKeyguardSecure
    }

    fun savePass(pass: String) {

        activity ?: return
        view ?: return

        SuperDigital.Builder(activity!!)
            .operation(OperationSavePassword(RequestSavePassword(pass)))
            .enqueue(object : SuperdigitalCallback<ResponseDefault> {
                override fun onSuccess(response: ResponseDefault) {
                    if (activity != null && view != null) {
                        response.toString()
                        preferencesRegister.setHasPass(true)

                        if (!preferencesRegister.numberCard.isNullOrEmpty()) {

                            startActivity(
                                Intent(this@PasswordCardFragment.context, HomeActivity::class.java).setFlags(
                                    Intent.FLAG_ACTIVITY_NEW_TASK
                                )
                            )
                            this@PasswordCardFragment.activity?.finish()
                        } else {
                            preferencesRegister.savePassword("")
                            initFp()
                        }

                        if (!preferencesRegister.numberCardState)
                            preferencesRegister.saveNumberCard("")
                    }
                }

                override fun onFailure(error: Error) {
                    activity ?: return
                    view ?: return
                    preferencesRegister.setHasPass(false)
                    activity!!.showSB(if (error.messages.isNotEmpty()) error.messages[0] else getString(R.string.generic_error2))
                }
            })
    }


    private fun initFp() {
        if (preferencesRegister.hasPass()) {
            if (fingerprintAvailable()) {
                tvFingerPrint.visibility = View.VISIBLE
                initiFingerprintDialog()
            }
        }
    }

}