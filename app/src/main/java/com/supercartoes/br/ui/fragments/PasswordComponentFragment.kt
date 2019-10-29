package com.supercartoes.br.ui.fragments


import android.app.Activity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import com.supercartoes.br.R
import com.supercartoes.br.ui.activities.PasswordActivity
import com.supercartoes.br.ui.utils.SDUtil
import com.supercartoes.br.ui.utils.showKeyboard
import com.supercartoes.br.utils.PasswordComponent

/**
 * @author Mario Guerra on 10/07/2019
 */

private const val ARG_PARAM1 = "param1"
private const val COUNT = "count"

class PasswordComponentFragment : Fragment() {
    private var param1: String? = null
    private var count: Int? = 6
    private var listener: OnFragmentPasswordListener? = null
    private var listenerDone: OnFragmentPasswordDoneListener? = null
    lateinit var etPassword: EditText
    lateinit var mView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            count = it.getInt(COUNT)
        }

        userVisibleHint = false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.fragment_password_component, container, false)

        val passwordComponent = mView.findViewById<PasswordComponent>(R.id.pc)

        etPassword = mView.findViewById(R.id.etPassword)
        //### Password

        try {
            Handler().postDelayed({
                if (listener != null)
                    listener!!.onCharacterPasswordFragmentPassword("", etPassword)
            }, 300)

        } catch (e: Exception) {
            //  e.logCrashLytics()
        }
        etPassword.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(count!!))

        passwordComponent.quantity = count!!

        passwordComponent.setQtt(count!!)

        etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                passwordComponent.managerDigits(s!!.length)
                if (activity is PasswordActivity && s.length == 4) {
                    if (listenerDone != null)
                        listenerDone!!.onPasswordDone(etPassword.text.toString())
                }
            }
        })

        etPassword.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                Log.i("TAG", "clicked")
                SDUtil.hideKeyboard(activity as Activity)
                if (listenerDone != null)
                    listenerDone!!.onPasswordDone(etPassword.text.toString())
                true
            } else {
                false
            }
        }

        return mView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etPassword.showKeyboard()

    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        if (activity == null)
            return
        super.setUserVisibleHint(isVisibleToUser)

    }

    fun setListener(listener: OnFragmentPasswordListener) {
        this.listener = listener
    }

    interface OnFragmentPasswordListener {
        fun onCharacterPasswordFragmentPassword(password: String, etPassword: EditText)
    }

    interface OnFragmentPasswordDoneListener {
        fun onPasswordDone(password: String)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, count: Int) =
            PasswordComponentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putInt(COUNT, count)
                }
            }
    }


}
