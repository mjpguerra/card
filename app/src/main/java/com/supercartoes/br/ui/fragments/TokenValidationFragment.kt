package com.supercartoes.br.ui.fragments

import android.os.AsyncTask
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.supercartoes.br.R
import com.supercartoes.br.repository.AppPreferencesRegister
import com.supercartoes.br.ui.activities.LoginActivity
import com.supercartoes.br.ui.activities.PasswordActivity
import com.supercartoes.br.ui.utils.Const
import com.supercartoes.br.ui.utils.minuteSecond
import com.supercartoes.br.ui.utils.showKeyboard
import com.supercartoes.br.ui.utils.showSB
import kotlinx.android.synthetic.main.fragment_sms_code.view.*
import layout.superdigital.com.superdigitallayout.animator.CentralAnimator
import superdigital.com.superdigitalotp.callbacks.SuperdigitalCallback
import superdigital.com.superdigitalotp.main.SuperDigital
import superdigital.com.superdigitalotp.operations.OperationValidateAuthCode
import superdigital.com.superdigitalotp.operations.responses.ResponseAuthCode
import superdigital.com.superdigitalotp.repository.models.Error
import superdigital.com.superdigitalotp.utils.DebugSuperdigital
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * @author Mario Guerra on 10/07/2019
 */

class TokenValidationFragment : Fragment() {

    lateinit var etSmsCode: EditText
    private lateinit var tvError: TextView
    private lateinit var preferencesRegister: AppPreferencesRegister
    lateinit var mView: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferencesRegister = AppPreferencesRegister(activity)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sms_code, container, false)

        mView = view

        initWidgets(view)
        return view
    }

    fun initWidgets(view: View) {

        etSmsCode = view.findViewById(R.id.etSmsCode)
        tvError = view.findViewById(R.id.tvError)
        etSmsCode.showKeyboard()

        etSmsCode.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s!!.length == 6) {
                    if (!validateField()) {
                        CentralAnimator.startAnimatorError(view)
                    } else {
                        checkToken()
                    }
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })


        RefreshCountDown().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
    }

    fun checkToken() {
        val act = (activity as LoginActivity)

        act.showLoader(getString(R.string.validating_token))

        SuperDigital.Builder((this@TokenValidationFragment.activity as LoginActivity))
            .operation(
                OperationValidateAuthCode(
                    SuperDigital.AuthType.SMS,
                    preferencesRegister.numberPhone,
                    etSmsCode.text.toString(),
                    false
                )
            )
            .enqueue(object : SuperdigitalCallback<ResponseAuthCode> {
                override fun onFailure(error: Error) {
                    act.hideLoader()
                    if (activity != null && view != null) {
                        activity!!.showSB(
                            if (error.messages.isNotEmpty()) error.messages[0] else getString(R.string.generic_error2),
                            time = Toast.LENGTH_SHORT
                        )
                        DebugSuperdigital.Log.e("ERROR", "Error: ${error.messages}")
                    }
                }

                override fun onSuccess(response: ResponseAuthCode) {
                    act.hideLoader()
                    DebugSuperdigital.Log.i("onSuccess", "response: $response")
                    preferencesRegister.saveTokenDevice(true)
                    val fm = activity?.supportFragmentManager
                    for (i in 0 until (fm?.backStackEntryCount ?: 0)) {
                        fm?.popBackStackImmediate()
                    }
                    (activity as LoginActivity).mReplaceFragment(
                        LoginFragment.newInstance(),
                        Const.OPEN_ACCOUNT_TWO,
                        false
                    )

                }
            })
    }

    private fun validateField(): Boolean {
        val valueField = etSmsCode.text.toString()
        if (valueField.isEmpty() || valueField.length < 6) {
            etSmsCode.error = resources.getString(R.string.sms_code_error)
            return false
        }
        return true
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            TokenValidationFragment().apply {}
    }


    inner class RefreshCountDown : AsyncTask<Void, Date, Void>() {

        var time: Long = 0

        override fun onPreExecute() {
            super.onPreExecute()
            mView.ctnCountDown.visibility = View.VISIBLE
            mView.notReceived.visibility = View.GONE
            time = TimeUnit.MINUTES.toMillis(5)
            mView.loaderCountDown.maxProgress = time.toFloat()
        }

        override fun doInBackground(vararg params: Void?): Void? {
//            var time = TimeUnit.MINUTES.toMillis(5)
            var interval = TimeUnit.MILLISECONDS.toMillis(250)
            for (i in 0..time step interval) {
                try {
                    Thread.sleep(interval)
                } catch (e: InterruptedException) {
                    //   e.logCrashLytics()
                }
                if (view == null)
                    return null
                publishProgress(Date(time - i))
            }
            return null
        }

        override fun onProgressUpdate(vararg values: Date?) {
            super.onProgressUpdate(*values)
            if (view == null)
                return
            view!!.loaderCountDown.progress = values[0]!!.time.toFloat()
            view!!.time.text = values[0]!!.minuteSecond()

        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            if (view == null)
                return
            view!!.ctnCountDown.visibility = View.GONE
            view!!.notReceived.visibility = View.VISIBLE
            view!!.notReceived.setOnClickListener {
                //                (activity as TokenActivity).onBackPressed()
                checkToken()
            }
        }
    }

}
