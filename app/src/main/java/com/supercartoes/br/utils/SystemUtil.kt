package com.supercartoes.br.utils

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.hardware.Sensor
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.supercartoes.br.ui.activities.LoginActivity

object SystemUtil {

    fun vibrateDevice(context: Context) {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(500)
        }
    }

    fun disableAccelerometerListening(activity: Activity, sensorEventListener: SensorEventListener) {
        // get the SensorManager
        val sensorManager = activity.getSystemService(
            Context.SENSOR_SERVICE
        ) as SensorManager

        // stop listening for accelerometer events
        sensorManager.unregisterListener(
            sensorEventListener,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        )

    }

    fun enableAccelerometerListening(activity: Activity, sensorEventListener: SensorEventListener) {
        // get the SensorManager
        val sensorManager = activity.getSystemService(
            Context.SENSOR_SERVICE
        ) as SensorManager

        // register to listen for accelerometer events
        sensorManager.registerListener(
            sensorEventListener,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL
        )

    }


    fun hideKeyboard(activity: Activity?, mView: View) {
        val imm = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(mView!!.windowToken, 0)
    }

    fun showKeyboard(activity: LoginActivity?, edittext: EditText?) {
        if (activity == null || edittext == null)
            return
        KeyboardUtil.keyboarForceShow(activity, edittext)
    }

    fun getWindowSize(context: Context): IntArray {
        val screenWidth: Int
        val screenHeight: Int
        val display = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager)
            .defaultDisplay
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            val point = Point()
            display.getSize(point)
            screenWidth = point.x
            screenHeight = point.y
        } else {
            screenWidth = display.width
            screenHeight = display.height
        }

        return intArrayOf(screenWidth, screenHeight)
    }

}
