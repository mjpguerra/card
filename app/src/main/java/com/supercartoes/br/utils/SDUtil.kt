package com.supercartoes.br.ui.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.Handler
import android.provider.MediaStore
import com.google.android.material.snackbar.Snackbar
import androidx.core.app.ActivityCompat.checkSelfPermission
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.widget.ImageViewCompat
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import android.util.Log
import android.view.*
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.supercartoes.br.BuildConfig
import com.supercartoes.br.R
import com.supercartoes.br.SuperDigitalApplication
import com.supercartoes.br.utils.CryptLib
import superdigital.com.superdigitalotp.repository.models.Error
import java.io.File
import java.io.FileOutputStream
import java.math.BigInteger
import java.security.MessageDigest
import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

const val WRITE = 77

class SDUtil {


    companion object {

         var error: Error? = null

        fun toDate(date: String): String {
            var result = ""
            try {
                var sdfnewformat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                val newDate = sdfnewformat.parse(date)
                sdfnewformat = SimpleDateFormat("dd/MM/yyyy")
                result = sdfnewformat.format(newDate)
            } catch (e: Exception) {
                //     e.logCrashLytics()
                return result
            }
            return result
        }

        fun toDateApi(date: String): String {
            var result = ""
            try {
                var sdfnewformat = SimpleDateFormat("dd/MM/yyyy")
                val newDate = sdfnewformat.parse(date)
                sdfnewformat = SimpleDateFormat("yyyy-MM-dd")
                result = sdfnewformat.format(newDate)
            } catch (e: Exception) {
                //  e.logCrashLytics()
                return result
            }
            return result
        }


        fun parseDate(string: String, format: String): Date? {
            val df = SimpleDateFormat(format)
            try {
                return df.parse(string)
            } catch (e: Exception) {
                //  e.logCrashLytics()
            }
            return null
        }

        fun getDate(dateString: String): String {
            val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            formatter.timeZone = TimeZone.getDefault()
            var value: Date? = null
            try {
                value = formatter.parse(dateString)
            } catch (e: ParseException) {
                //  e.logCrashLytics()
            }
            val dateFormatter = SimpleDateFormat("dd MMM")
            dateFormatter.timeZone = TimeZone.getDefault()

            return dateFormatter.format(value)
        }

        fun getDateObject(dateString: String): Date? {
            val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            formatter.timeZone = TimeZone.getDefault()
            var value: Date? = null
            try {
                value = formatter.parse(dateString)
            } catch (e: ParseException) {
                //   e.logCrashLytics()
            }
            return value
        }


        fun getString(str: Int, ctx: Context = SuperDigitalApplication.ctx) {
            ctx.getString(str)
        }


        fun setProgress(show: Boolean, view: View?, progressBar: ProgressBar?) {
            if (view != null && progressBar != null) {

                if (show) {
                    view.isClickable = false
                    progressBar.visibility = View.VISIBLE
                } else {
                    view.isClickable = true
                    progressBar.visibility = View.GONE
                }
            }
        }

        fun hideKeyboard(activity: Activity) {

            if (activity.currentFocus == null)
                return
            val inputManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(activity.currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }

        fun getInitials(name: String): String {

            var nameTrimmed = name.trim()
            if (nameTrimmed.isEmpty()) {
                return ""
            }

            val n = nameTrimmed.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

            val initials = if (n.size > 1) {
                n[0][0] + n[n.lastIndex][0].toString()
            } else {
                n[n.lastIndex][0].toString()
            }

            return initials.toUpperCase()
        }

        fun isPackageExisted(context: Context, targetPackage: String): Boolean {
            val pm = context.packageManager
            try {
                pm.getPackageInfo(targetPackage, PackageManager.GET_META_DATA)
            } catch (e: PackageManager.NameNotFoundException) {
                return false
            }

            return true
        }

        fun getCurrencyString(value: Double): String {
            return NumberFormat.getCurrencyInstance().format(value)
        }

        fun validateString(string: String?): Boolean = string != null && !string.equals("", ignoreCase = true)

        fun drawableToBitmap(drawable: Drawable): Bitmap {
            if (drawable is BitmapDrawable) {
                return drawable.bitmap
            }

            var width = drawable.intrinsicWidth
            width = if (width > 0) width else 1
            var height = drawable.intrinsicHeight
            height = if (height > 0) height else 1

            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)

            return bitmap
        }

        //tree edit password validation
        fun numbersAreConsecutive(password: String): Boolean {
            val number: CharArray = password.toCharArray()
            var count = 0
            for (i in number.indices) {
                if ((i + 1) < number.size)
                    if (java.lang.Math.abs(number[i + 1] - number[i]) == 1) count++
            }
            return count == (number.size - 1)
        }

        fun allEquals(password: String): Boolean {
            val number: CharArray = password.toCharArray()
            var count = 0
            for (i in number.indices) {
                if ((i + 1) < number.size)
                    if ((number[i] == number[i + 1])) count++
            }
            return count == (number.size - 1)
        }

        fun isBirthDate(password: String, birthDate: String): Boolean {

            if (birthDate == "") {
                return false
            }

            var dateFormatted: String = birthDate
            if (dateFormatted.contains("-")) {
                dateFormatted = toDate(birthDate)
            }
            //Convert DD/MM/AAAA to DDMMAA
            dateFormatted = dateFormatted.replace("/", "")
            dateFormatted = dateFormatted.substring(0, 4) + dateFormatted.substring(6)

            Log.d("CheckSenha", "niver: $dateFormatted")
            return dateFormatted == password
        }

        fun ofuscateInfo(field: String?, type: String): String? {
            try {
                if (field == null)
                    return null

                if (type == "email") {
                    var part = field.substring(2, 5)
                    return field.replace(part, "***")
                }

                if (type == "phone") {
                    var part = field.substring(4, 7)
                    return field.replace(part, "***")
                }
            } catch (e: Exception) {
                // e.logCrashLytics()
                return ""
            }

            return field
        }
    }
}

fun Double.currencyFormat(currency: String? = "R$"): String {
    var currencyFormatter = NumberFormat.getInstance()
    currencyFormatter.minimumFractionDigits = 2
    return SuperDigitalApplication.ctx.getString(R.string.currency_val, currency, currencyFormatter.format(this))
}

fun ImageView.loadUrl(url: String) {
    Glide.with(this)
        .load(url)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
//                    .placeholder(R.drawable.logo))
}

fun ImageView.loadUrl(url: ByteArray) {
    Glide.with(this)
        .load(url)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}

fun View.customizeToolbar(
    title: Int = 0,
    back: (() -> Unit)? = null,
    close: (() -> Unit)? = null,
    help: (() -> Unit)? = null
) {
    customizeToolbarTitleString(title.getResString(), back, close, help)
}

fun View.customizeToolbarTitleString(
    title: String? = "",
    back: (() -> Unit)? = null,
    close: (() -> Unit)? = null,
    help: (() -> Unit)? = null
) {
    val tvTitle = findViewById<TextView>(R.id.tvTitle)
    val ivBackArrow = findViewById<ImageView>(R.id.ivBackArrow)
    val ivClose = findViewById<ImageView>(R.id.ivClose)
    val ivHelp = findViewById<ImageView>(R.id.ivHelp)

    tvTitle.text = title

    ivBackArrow.visibility = if (back == null) {
        View.GONE
    } else {
        ivBackArrow.setOnClickListener { back() }
        View.VISIBLE
    }

    ivClose.visibility = if (close == null) {
        View.GONE
    } else {
        ivClose.setOnClickListener {
            close()
            ivClose.isEnabled = false
            Handler().postDelayed({
                ivClose.isEnabled = true
            }, 1000)
        }
        View.VISIBLE
    }

    ivHelp.visibility = if (help == null) {
        View.GONE
    } else {
        ivHelp.setOnClickListener {
            val mHandler = Handler()
            help()
            ivHelp.isEnabled = false
            Thread {
                Thread.sleep(1000)
                mHandler.post {
                    ivHelp.isEnabled = true
                }
            }.start()
        }
        View.VISIBLE
    }
}

fun View.addButtonAnimation() {

    this.setOnTouchListener { v, event ->
        when (event?.action) {

            MotionEvent.ACTION_DOWN -> {
                v.animate().scaleX(0.9f).setInterpolator(AccelerateDecelerateInterpolator()).duration = 300
                v.animate().scaleY(0.9f).setInterpolator(AccelerateDecelerateInterpolator()).duration = 300

                Handler().postDelayed({
                    v.animate().scaleX(1f).setInterpolator(AccelerateDecelerateInterpolator()).duration = 300
                    v.animate().scaleY(1f).setInterpolator(AccelerateDecelerateInterpolator()).duration = 300
                }, 300)
            }
        }
        v?.onTouchEvent(event) ?: true
    }
}

fun Int.getResString(): String {
    if (this == 0)
        return ""
    return try {
        SuperDigitalApplication.ctx.getString(this)
    } catch (e: Exception) {
        ""
    }
}

fun TextView.setErrorCuston(string: String?) {
    if (string == null) {
        visibility = View.GONE
    } else {
        visibility = View.VISIBLE
        text = string
    }
}


fun Date.getYearsOld(): Int {
    var dateOfBirth = GregorianCalendar()
    dateOfBirth.setTime(this)

    var today = GregorianCalendar()
    var age: Int = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR)

    dateOfBirth.add(Calendar.YEAR, age)
    if (today.before(dateOfBirth)) {
        age--
    }
    return age
}

fun Date.sun(quant: Int, period: Int) {
    var date = GregorianCalendar()
    date.setTime(this)
    date.add(period, quant)
    time = date.timeInMillis
}

fun Date.toString(string: String): String {
    val format = SimpleDateFormat(string)
    return format.format(this)
}

fun Date.hour(): String {
    return toString("HH")
}

fun Date.minute(): String {
    return toString("mm")
}

fun Date.isToday(): Boolean {
    return isEqualsDay(Date())
}

fun Date.isEqualsDay(date: Date): Boolean {

    var d1 = SDUtil.parseDate(toString("yyyyMMdd"), "yyyyMMdd")
    var d2 = SDUtil.parseDate(date.toString("yyyyMMdd"), "yyyyMMdd")

    return d1 == d2
}

fun Date.second(): String {
    return toString("ss")
}

fun Date.dayOfMonth(): String {
    return toString("dd")
}

fun Date.month(): String {
    return toString("MM")
}

fun Date.year(): String {
    return toString("yyyy")
}

fun Date.minuteSecond(): String {
    return minute() + ":" + second()
}

fun Date.hourMinute(): String {
    return hour() + ":" + minute()
}

fun Date.hourMinuteSecond(): String {
    return hour() + ":" + minute() + ":" + second()
}

fun Date.toFullDateTime(): String {
    return toString("dd MMM yyyy 'às' HH:mm")
}

fun EditText.showKeyboard() {
    Handler().postDelayed({

        this.requestFocus()
        val imm: InputMethodManager = context!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)

    }, 200)

}

fun TextView.dismissKeyboard() {

    val imm: InputMethodManager = context!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
//        requestFocus()

//    if (isFocused && imm.isActive)
    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
}

fun String.isEmail(): Boolean {
    var error = false
    if (this.isEmpty())
        error = true
    else {
        val ePattern =
            "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"
        val p = java.util.regex.Pattern.compile(ePattern)
        val m = p.matcher(this)
        if (!m.matches())
            error = true
    }

    return error
}



fun Activity.showCustomDialog(
    image: Int? = null,
    title: Int? = null,
    subtitle: Int? = null,
    yes: (() -> Unit)? = null,
    no: (() -> Unit)? = null,
    yesTitle: Int? = null,
    noTitle: Int? = null,
    subtitleString: String? = null,
    underText: Int? = null,
    underTextAction: (() -> Unit)? = null,
    yesDismissesDialog: Boolean? = false,
    noDismissesDialog: Boolean? = false,
    extraString: String? = null,
    cancel: (() -> Unit)? = null,
    showClose: Boolean? = false,
    dismissOutside: Boolean? = true,
    titleString: String? = null,
    isRating: Boolean = false,
    close: (() -> Unit)? = null
) {

    lateinit var ivClose: ImageView
    lateinit var mImg: ImageView
    lateinit var mTitle: TextView
    lateinit var mSubTitle: TextView
    lateinit var mBtnYes: Button
    lateinit var mBtnNo: Button
    lateinit var mTvUnderText: TextView
    lateinit var mCardViewDialog: CardView

    val view = this.layoutInflater.inflate(R.layout.custom_dialog, null)

    val alert = AlertDialog.Builder(this)
    alert.setView(view)
    val dialog = alert.create()

    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    ivClose = view.findViewById(R.id.ivClose)
    mImg = view.findViewById(R.id.img)
    mTitle = view.findViewById(R.id.title)
    mSubTitle = view.findViewById(R.id.subTitle)
    mBtnYes = view.findViewById(R.id.btnYes)
    mBtnNo = view.findViewById(R.id.btnNo)
    mTvUnderText = view.findViewById(R.id.mTvUnderText)
    mCardViewDialog = view.findViewById(R.id.cvCustomDialog)

    mBtnYes.addButtonAnimation()
    mBtnNo.addButtonAnimation()


    dialog.setCanceledOnTouchOutside(dismissOutside ?: true)
    if (!dismissOutside!!) {
        dialog.setOnKeyListener(object : DialogInterface.OnKeyListener {
            override fun onKey(dialog: DialogInterface?, keyCode: Int, event: KeyEvent?): Boolean {
                if (keyCode == KeyEvent.KEYCODE_BACK && event?.getAction() == KeyEvent.ACTION_UP && !event.isCanceled()) {
                    return true
                }
                return false
            }
        })
    }

    if (image != null) {
        mImg.setImageDrawable(ContextCompat.getDrawable(this.applicationContext, image))
    } else {
        mImg.visibility = View.GONE
    }

    if (title != null || titleString != null) {
        if (extraString != null) {
            mTitle.text =
                if (title != null) this.applicationContext.getString(title, extraString) else titleString + extraString
        } else {
            mTitle.text = if (title != null) this.applicationContext.getText(title) else titleString
        }

        mTitle.visibility = View.VISIBLE
    } else {
        mTitle.visibility = View.GONE
    }

    if (subtitle != null || subtitleString != null) {
        if (extraString != null) {
            mSubTitle.text = if (subtitle != null) this.applicationContext.getString(
                subtitle,
                extraString
            ) else subtitleString + extraString
        } else {
            mSubTitle.text = if (subtitle != null) this.applicationContext.getText(subtitle) else subtitleString
        }

        mSubTitle.visibility = View.VISIBLE
    } else {
        mSubTitle.visibility = View.GONE
    }

    if (yes != null) {
        mBtnYes.setOnClickListener {
            yes()
            if (yesDismissesDialog!!) {
                dialog.dismiss()
            }
        }
    } else {
        mBtnYes.visibility = View.GONE
    }

    if (no != null) {
        mBtnNo.setOnClickListener {
            no()
            if (noDismissesDialog!!) {
                dialog.dismiss()
            }
        }
    } else {
        mBtnNo.visibility = View.GONE

//        mBtnNo.setOnClickListener {
//            dialog.dismiss()
//        }
    }

    if (yesTitle != null) {
        mBtnYes.text = this.applicationContext.getText(yesTitle)
        mBtnYes.visibility = View.VISIBLE
    }

    if (noTitle != null) {
        mBtnNo.text = this.applicationContext.getText(noTitle)
    }

    if (cancel != null) {
        dialog.setOnCancelListener {
            cancel()
        }
    }

    if (close != null) {
        dialog.setOnCancelListener {
            close()
        }
    }

    if (underText != null) {
        mTvUnderText.text = this.applicationContext.getText(underText)

        mTvUnderText.setOnClickListener {
            if (underTextAction != null) {
                underTextAction()
            }
            dialog.dismiss()
        }


    } else {
        mTvUnderText.visibility = View.GONE
    }

    if (showClose!!) {
        ivClose.visibility = View.VISIBLE

        ivClose.setOnClickListener {
            dialog.dismiss()
        }


    }

    if (isRating) {
        mCardViewDialog.setBackgroundResource(R.drawable.bg_rating_dialog)
        mTitle.setTextColor(resources.getColor(R.color.white))
        mBtnYes.setBackgroundResource(R.drawable.bg_button_white)
        mBtnYes.setTextColor(resources.getColor(R.color.colorPrimary))

    }



    dialog.show()
}


fun ProgressBar.configLoader(colored: Boolean) {
    val color = if (colored) R.color.colorPrimaryDark else R.color.white
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
        val wrapDrawable = DrawableCompat.wrap(this.indeterminateDrawable)
        wrapDrawable.tint(ContextCompat.getColor(context!!, color))
    } else {
        this.indeterminateDrawable.setColorFilter(ContextCompat.getColor(context!!, color), PorterDuff.Mode.SRC_IN)
    }
}

fun Drawable.tint(color: Int) {
    DrawableCompat.setTint(this, color)
}

fun Drawable.tint(iv: ImageView, color: Int) {
    ImageViewCompat.setImageTintList(iv, ColorStateList.valueOf(color))
}

fun Context.dpFromPx(context: Context, px: Float): Float {
    return px / context.resources.displayMetrics.density
}

fun Context.pxFromDp(dp: Float): Int {
    return (dp * resources.displayMetrics.density).toInt()
}

fun Activity.showSB(text: String, view: View? = null, time: Int? = Snackbar.LENGTH_INDEFINITE, isRed: Boolean = false) {
    val sb = Snackbar.make(view ?: this.window.decorView.rootView, text, time!!)


    var sb_tv = sb.view.findViewById<TextView>(R.id.snackbar_text)

    sb_tv.let {
        sb_tv.maxLines = 5
    }


    if (isRed) {
        sb.view.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.md_red_A700))
    }
    sb.setActionTextColor(ContextCompat.getColor(baseContext, R.color.white))

    if (sb.view.layoutParams is FrameLayout.LayoutParams) {

        val layoutParams = sb.view.layoutParams as FrameLayout.LayoutParams
        layoutParams.gravity = Gravity.TOP
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
        sb.view.layoutParams = layoutParams
        if (view == null) {
            layoutParams.topMargin = pxFromDp(22f)
        }
    }

    if (time == Snackbar.LENGTH_INDEFINITE) {
        sb.setAction("Ok") {
            sb.dismiss()
        }
    }
    sb.show()
}


fun Activity.shareScreenShot(screenView: View) {

    val camPermission = checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    if (camPermission != PackageManager.PERMISSION_GRANTED) {
        requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), WRITE
        )
    } else {
        val now = Date()
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now)

        try {
            // image naming and path  to include sd card  appending name you choose for file
            val mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg"

            // create bitmap screen capture
//                val v1 = window.decorView.rootView
            val v1 = screenView
            v1.isDrawingCacheEnabled = true
            val bitmap = Bitmap.createBitmap(v1.drawingCache)
            v1.isDrawingCacheEnabled = false

            val imageFile = File(mPath)

            val outputStream = FileOutputStream(imageFile)
            val quality = 100
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream)
            outputStream.flush()
            outputStream.close()


            val path = MediaStore.Images.Media.insertImage(contentResolver, bitmap, "Image Description", null)
            val uri = Uri.parse(path)

            val shareIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, uri)
                type = "image/jpeg"
            }
            startActivity(Intent.createChooser(shareIntent, getString(R.string.send)))

        } catch (e: Throwable) {
            // Several error may come out with file handling or DOM
            e.printStackTrace()
        }
    }
}

fun String.formatDoc(): String {
    return try {
        if (this.length < 14) {
            this.substring(0, 3) + "." + this.substring(3, 6) + "." + this.substring(6, 9) + "-" + this.substring(9, 11)
        } else {
            this.substring(0, 2) + "." + this.substring(2, 5) + "." + this.substring(5, 8) + "/" + this.substring(
                8,
                12
            ) + "-" + this.substring(12, 14)
        }
    } catch (e: java.lang.Exception) {
        //   e.logCrashLytics()
        ""
    }
}


fun String.decrypt(context: Context): String {
    var output = ""
    try {
        val _crypt = CryptLib()
        output = _crypt.decrypt(this, context.getString(R.string.key), context.getString(R.string.iv))
    } catch (e: Exception) {
        //    e.logCrashLytics()
    }

    return output
}

fun String.encrypt(context: Context): String {
    var output = ""
    try {
        val _crypt = CryptLib()
        output = _crypt.encrypt(this, context.getString(R.string.key), context.getString(R.string.iv))
    } catch (e: Exception) {
        //  e.logCrashLytics()
    }

    return output
}


fun View.preventDoubleClick() {
    this.isClickable = false

    Handler().postDelayed({
        this.isClickable = true
    }, 500)
}


fun String.toDoubleSD(): Double {
    val s = this.replace(".", "")
    val s2 = s.replace(",", ".")
    return s2.toDouble()
}

fun ViewGroup.forInChild(event: ((View) -> Unit)) {
    for (i in 0..childCount - 1) {
        event(getChildAt(i))
    }

}


fun String.toMd5(): String {
    var md = MessageDigest.getInstance("MD5")
    return String.format("%032x", BigInteger(1, md.digest(this.toByteArray())))
}


fun String.isTelefone(): Boolean {
    return this.matches(".((10)|([1-9][1-9]).)\\s9?[0-9][0-9]{3}-[0-9]{4}".toRegex()) || this.matches(".((10)|([1-9][1-9]).)\\s[2-5][0-9]{3}-[0-9]{4}".toRegex())
}

fun View.changeVisibity(visibility: Int) {
    if (this.visibility != visibility) {
        this.visibility = visibility
    }
}







