package com.supercartoes.br.utils

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import com.supercartoes.br.R

class PasswordComponent : LinearLayout {

    var attrs: AttributeSet? = null
    var quantity = resources.getInteger(R.integer.pin_quantity)

    lateinit var llContainerMain: LinearLayout

    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
    )
            : super(context, attrs, defStyleAttr)

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    )
            : super(context, attrs, defStyleAttr, defStyleRes)

    fun setQtt(qtt: Int) {

        quantity = qtt
        var view = LayoutInflater.from(context).inflate(R.layout.password_custom_component, this, true)
        llContainerMain = view.findViewById<LinearLayout>(R.id.llContainerMain)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.password_component_custom, 0, 0
            )

            var quantityStr = resources.getText(
                typedArray
                    .getResourceId(
                        R.styleable.password_component_custom_quantity,
                        if (quantity == 6) {
                            R.string.quantity_password_chars_six
                        } else {
                            R.string.quantity_password_chars_four
                        }
                    )
            )

            if (quantityStr.isNotEmpty())
                quantity = quantityStr as Int


            typedArray.recycle()
        }

        managerQuantityComponents(quantity)
    }


    private fun managerQuantityComponents(quantity: Int) {
        when (quantity) {
            1 -> {
                setVisibilityComponent(intArrayOf(0))
            }
            2 -> {
                setVisibilityComponent(intArrayOf(0, 1))
            }
            3 -> {
                setVisibilityComponent(intArrayOf(0, 1, 2))
            }
            4 -> {
                setVisibilityComponent(intArrayOf(0, 1, 2, 3))
            }
            5 -> {
                setVisibilityComponent(intArrayOf(0, 1, 2, 3, 4))
            }
            6 -> {
                setVisibilityComponent(intArrayOf(0, 1, 2, 3, 4, 5))
            }
            7 -> {
                setVisibilityComponent(intArrayOf(0, 1, 2, 3, 4, 5, 6))
            }
            8 -> {
                setVisibilityComponent(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7))
            }

            else -> {
                setVisibilityComponent(intArrayOf(0, 1, 2, 3, 4, 5))
            }
        }

    }

    private fun setVisibilityComponent(childs: IntArray) {
        for (q: Int in childs) {
            llContainerMain.getChildAt(q).visibility = View.VISIBLE
        }
    }

    fun managerDigits(character: Int) {
        if (character <= quantity) {
            setVisibilityCheckComponent(character)
        } else {
            Toast.makeText(context, "Apenas " + quantity + " caracteres", Toast.LENGTH_SHORT).show()
        }


    }

    private fun setVisibilityCheckComponent(characters: Int) {
        var c = characters
        while (c > 0) {
            (llContainerMain.getChildAt(c - 1) as FrameLayout).getChildAt(0).visibility = View.VISIBLE

            c--
        }
        cleanOthersComponents(characters)
    }

    private fun cleanOthersComponents(characters: Int) {
        var quantityReverte = quantity
        while (quantityReverte > characters) {
            (llContainerMain.getChildAt(quantityReverte - 1) as FrameLayout).getChildAt(0).visibility = View.GONE
            quantityReverte--
        }


    }

}