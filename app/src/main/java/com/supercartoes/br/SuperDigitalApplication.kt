package com.supercartoes.br

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import android.util.Log
import com.supercartoes.br.ui.utils.Const
import superdigital.com.superdigitalotp.main.SuperDigital
import superdigital.com.superdigitalotp.utils.Util

class SuperDigitalApplication : MultiDexApplication() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        @get:Synchronized
        lateinit var initializer: SuperDigitalApplication
            private set

        @SuppressLint("StaticFieldLeak")
        lateinit var ctx: Context

    }

    override fun onCreate() {
        super.onCreate()
        initializer = this
        ctx = applicationContext
        MultiDex.install(this)
    }


    fun initializeLib(activity: Activity) {
        SuperDigital.apply {

            initialize(activity, "", false, true, "")
            version = BuildConfig.VERSION_NAME.replaceAfter("-", "").replace("-", "")
            systemVersion = Build.VERSION.SDK_INT.toString()
        }

    }
}
