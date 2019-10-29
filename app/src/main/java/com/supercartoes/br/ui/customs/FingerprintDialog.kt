package com.supercartoes.br.ui.customs

import android.os.Build
import android.os.Bundle
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyPermanentlyInvalidatedException
import android.security.keystore.KeyProperties
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import androidx.core.hardware.fingerprint.FingerprintManagerCompat
import androidx.fragment.app.DialogFragment
import com.supercartoes.br.R
import com.supercartoes.br.repository.AppPreferencesRegister
import com.supercartoes.br.ui.activities.PasswordActivity
import kotlinx.android.synthetic.main.fingerprint_dialog.*
import superdigital.com.superdigitalotp.callbacks.SuperdigitalCallback
import superdigital.com.superdigitalotp.main.SuperDigital
import superdigital.com.superdigitalotp.operations.OperationGetPassword
import superdigital.com.superdigitalotp.operations.responses.ResponseGetPassword
import superdigital.com.superdigitalotp.repository.models.Error
import java.io.IOException
import java.security.*
import java.security.cert.CertificateException
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.NoSuchPaddingException
import javax.crypto.SecretKey

/**
 * @author Mario Guerra on 10/07/2019
 */

@RequiresApi(Build.VERSION_CODES.M)
class FingerprintDialog : DialogFragment(), FingerprintController.Callback {

    private lateinit var btnCancel: AppCompatButton
    private lateinit var progress_circular: ProgressBar
    private lateinit var preferencesRegister: AppPreferencesRegister

    private val controller: FingerprintController by lazy {
        FingerprintController(
            FingerprintManagerCompat.from(context!!),
            this,
            titleTextView,
            subtitleTextView,
            errorTextView,
            iconFinger
        )
    }

    /**
     * CryptoObject is a wrapper class for any cryptography required by the FingerprintManager.
     * https://developer.android.com/reference/android/support/v4/hardware/fingerprint/FingerprintManagerCompat.CryptoObject.html
     */
    private var cryptoObject: FingerprintManagerCompat.CryptoObject? = null

    /**
     * KeyStore is the device's storage for any cryptographic keys and certificates. We use this to get a key for the fingerprint manager.
     * https://developer.android.com/reference/java/security/KeyStore.html
     */
    private var keyStore: KeyStore? = null

    /**
     * This class is used to generate the keys that were reference from the [keyStore].
     * https://developer.android.com/reference/javax/crypto/KeyGenerator.html
     */
    private var keyGenerator: KeyGenerator? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fingerprint_dialog, container, false)
        progress_circular = view.findViewById(R.id.progress_circular)
        btnCancel = view.findViewById(R.id.btnCancel)
        btnCancel.setOnClickListener {
            dismiss()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        controller.setTitle(arguments!!.getString(ARG_TITLE)!!)
        controller.setSubtitle(arguments!!.getString(ARG_SUBTITLE)!!)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferencesRegister = AppPreferencesRegister(activity)

        try {
            keyStore = KeyStore.getInstance("AndroidKeyStore")
        } catch (e: KeyStoreException) {
            throw RuntimeException("Failed to get an instance of KeyStore", e)
        }

        try {
            keyGenerator = KeyGenerator
                .getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException("Failed to get an instance of KeyGenerator", e)
        } catch (e: NoSuchProviderException) {
            throw RuntimeException("Failed to get an instance of KeyGenerator", e)
        }

        createKey(KEY_NAME, false)

        val cipher: Cipher
        try {
            cipher = Cipher.getInstance(
                KeyProperties.KEY_ALGORITHM_AES + "/"
                        + KeyProperties.BLOCK_MODE_CBC + "/"
                        + KeyProperties.ENCRYPTION_PADDING_PKCS7
            )
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException("Failed to get an instance of Cipher", e)
        } catch (e: NoSuchPaddingException) {
            throw RuntimeException("Failed to get an instance of Cipher", e)
        }

        if (initCipher(cipher, KEY_NAME)) {
            cryptoObject = FingerprintManagerCompat.CryptoObject(cipher)
        }
    }

    override fun onResume() {
        super.onResume()

        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        cryptoObject?.let {
            controller.startListening(it)
        }
    }

    override fun onPause() {
        super.onPause()
        controller.stopListening()
    }

    override fun onAuthenticated() {
        try {
            if (activity != null) {
                SuperDigital.Builder(activity!!)
                    .operation(OperationGetPassword())
                    .enqueue(object : SuperdigitalCallback<ResponseGetPassword> {

                        override fun onSuccess(response: ResponseGetPassword) {
                            response.toString()
                            (activity as PasswordActivity).actLibLogin(response.pass)
                        }

                        override fun onFailure(error: Error) {
                            // App.validateError(activity!!, error)
                        }
                    })
            }
//            (activity as LoginActivity).actLibLogin(arguments!!.getString(CPF)!!, preferencesRegister.passwordSix.decrypt(context!!), preferencesRegister.saveCpfState)
            this.dismiss()
//            libLogin(arguments!!.getString(CPF)!!, preferencesRegister.passwordSix.decrypt(context!!), preferencesRegister.saveCpfState)
        } catch (e: Exception) {
            // e.logCrashLytics()
        }
    }

    override fun onError() {
        //TODO:
    }

    /**
     * Lifted code from the Google samples - https://github.com/googlesamples/android-FingerprintDialog/blob/master/kotlinApp/app/src/main/java/com/example/android/fingerprintdialog/MainActivity.kt
     *
     * Initialize the [Cipher] instance with the created key in the
     * [.createKey] method.
     *
     * @param keyName the key name to init the cipher
     * @return `true` if initialization is successful, `false` if the lock screen has
     * been disabled or reset after the key was generated, or if a fingerprint got enrolled after
     * the key was generated.
     */
    private fun initCipher(cipher: Cipher, keyName: String): Boolean {
        try {
            keyStore?.load(null)
            val key = keyStore?.getKey(keyName, null) as SecretKey
            cipher.init(Cipher.ENCRYPT_MODE, key)
            return true
        } catch (e: KeyPermanentlyInvalidatedException) {
            return false
        } catch (e: KeyStoreException) {
            throw RuntimeException("Failed to init Cipher", e)
        } catch (e: CertificateException) {
            throw RuntimeException("Failed to init Cipher", e)
        } catch (e: UnrecoverableKeyException) {
            throw RuntimeException("Failed to init Cipher", e)
        } catch (e: IOException) {
            throw RuntimeException("Failed to init Cipher", e)
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException("Failed to init Cipher", e)
        } catch (e: InvalidKeyException) {
            throw RuntimeException("Failed to init Cipher", e)
        }
    }

    /**
     * Lifted code from the Google Samples - https://github.com/googlesamples/android-FingerprintDialog/blob/master/kotlinApp/app/src/main/java/com/example/android/fingerprintdialog/MainActivity.kt
     *
     * Creates a symmetric key in the Android Key Store which can only be used after the user has
     * authenticated with fingerprint.
     *
     * @param keyName the name of the key to be created
     * @param invalidatedByBiometricEnrollment if `false` is passed, the created key will not
     * be invalidated even if a new fingerprint is enrolled.
     * The default value is `true`, so passing
     * `true` doesn't change the behavior
     * (the key will be invalidated if a new fingerprint is
     * enrolled.). Note that this parameter is only valid if
     * the app works on Android N developer preview.
     */
    private fun createKey(keyName: String, invalidatedByBiometricEnrollment: Boolean) {
        try {
            keyStore?.load(null)

            val builder = KeyGenParameterSpec.Builder(
                keyName,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
            )
                .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                .setUserAuthenticationRequired(true)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                builder.setInvalidatedByBiometricEnrollment(invalidatedByBiometricEnrollment)
            }
            keyGenerator?.init(builder.build())
            keyGenerator?.generateKey()
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        } catch (e: InvalidAlgorithmParameterException) {
            throw RuntimeException(e)
        } catch (e: CertificateException) {
            throw RuntimeException(e)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }

    }

    companion object {
        val FRAGMENT_TAG: String = FingerprintDialog::class.java.simpleName

        private val ARG_TITLE = "ArgTitle"
        private val ARG_SUBTITLE = "ArgSubtitle"
        private val NUMBER_CARD = "Number_card"

        private val KEY_NAME = "user_key"

        fun newInstance(title: String, subtitle: String, number: String): FingerprintDialog {
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            args.putString(ARG_SUBTITLE, subtitle)
            args.putString(NUMBER_CARD, number)

            val fragment = FingerprintDialog()
            fragment.arguments = args

            return fragment
        }
    }
}