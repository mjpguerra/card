package com.supercartoes.br.ui.customs;

import java.lang.System;

/**
 * * @author Mario Guerra on 10/07/2019
 */
@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\u0012\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010)\u001a\u00020\u0017H\u0016J\b\u0010*\u001a\u00020\u0017H\u0016J\b\u0010+\u001a\u00020\u0017H\u0016J\u001a\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/supercartoes/br/ui/customs/FingerprintDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/supercartoes/br/ui/customs/FingerprintController$Callback;", "()V", "btnCancel", "Landroidx/appcompat/widget/AppCompatButton;", "controller", "Lcom/supercartoes/br/ui/customs/FingerprintController;", "getController", "()Lcom/supercartoes/br/ui/customs/FingerprintController;", "controller$delegate", "Lkotlin/Lazy;", "cryptoObject", "Landroidx/core/hardware/fingerprint/FingerprintManagerCompat$CryptoObject;", "keyGenerator", "Ljavax/crypto/KeyGenerator;", "keyStore", "Ljava/security/KeyStore;", "preferencesRegister", "Lcom/supercartoes/br/repository/AppPreferencesRegister;", "progress_circular", "Landroid/widget/ProgressBar;", "createKey", "", "keyName", "", "invalidatedByBiometricEnrollment", "", "initCipher", "cipher", "Ljavax/crypto/Cipher;", "onAuthenticated", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onError", "onPause", "onResume", "onViewCreated", "view", "Companion", "app_debug"})
public final class FingerprintDialog extends androidx.fragment.app.DialogFragment implements com.supercartoes.br.ui.customs.FingerprintController.Callback {
    private androidx.appcompat.widget.AppCompatButton btnCancel;
    private android.widget.ProgressBar progress_circular;
    private com.supercartoes.br.repository.AppPreferencesRegister preferencesRegister;
    private final kotlin.Lazy controller$delegate = null;
    
    /**
     * * CryptoObject is a wrapper class for any cryptography required by the FingerprintManager.
     *     * https://developer.android.com/reference/android/support/v4/hardware/fingerprint/FingerprintManagerCompat.CryptoObject.html
     */
    private androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject cryptoObject;
    
    /**
     * * KeyStore is the device's storage for any cryptographic keys and certificates. We use this to get a key for the fingerprint manager.
     *     * https://developer.android.com/reference/java/security/KeyStore.html
     */
    private java.security.KeyStore keyStore;
    
    /**
     * * This class is used to generate the keys that were reference from the [keyStore].
     *     * https://developer.android.com/reference/javax/crypto/KeyGenerator.html
     */
    private javax.crypto.KeyGenerator keyGenerator;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FRAGMENT_TAG = null;
    private static final java.lang.String ARG_TITLE = "ArgTitle";
    private static final java.lang.String ARG_SUBTITLE = "ArgSubtitle";
    private static final java.lang.String NUMBER_CARD = "Number_card";
    private static final java.lang.String KEY_NAME = "user_key";
    public static final com.supercartoes.br.ui.customs.FingerprintDialog.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.supercartoes.br.ui.customs.FingerprintController getController() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onAuthenticated() {
    }
    
    @java.lang.Override()
    public void onError() {
    }
    
    /**
     * * Lifted code from the Google samples - https://github.com/googlesamples/android-FingerprintDialog/blob/master/kotlinApp/app/src/main/java/com/example/android/fingerprintdialog/MainActivity.kt
     *     *
     *     * Initialize the [Cipher] instance with the created key in the
     *     * [.createKey] method.
     *     *
     *     * @param keyName the key name to init the cipher
     *     * @return `true` if initialization is successful, `false` if the lock screen has
     *     * been disabled or reset after the key was generated, or if a fingerprint got enrolled after
     *     * the key was generated.
     */
    private final boolean initCipher(javax.crypto.Cipher cipher, java.lang.String keyName) {
        return false;
    }
    
    /**
     * * Lifted code from the Google Samples - https://github.com/googlesamples/android-FingerprintDialog/blob/master/kotlinApp/app/src/main/java/com/example/android/fingerprintdialog/MainActivity.kt
     *     *
     *     * Creates a symmetric key in the Android Key Store which can only be used after the user has
     *     * authenticated with fingerprint.
     *     *
     *     * @param keyName the name of the key to be created
     *     * @param invalidatedByBiometricEnrollment if `false` is passed, the created key will not
     *     * be invalidated even if a new fingerprint is enrolled.
     *     * The default value is `true`, so passing
     *     * `true` doesn't change the behavior
     *     * (the key will be invalidated if a new fingerprint is
     *     * enrolled.). Note that this parameter is only valid if
     *     * the app works on Android N developer preview.
     */
    private final void createKey(java.lang.String keyName, boolean invalidatedByBiometricEnrollment) {
    }
    
    public FingerprintDialog() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/supercartoes/br/ui/customs/FingerprintDialog$Companion;", "", "()V", "ARG_SUBTITLE", "", "ARG_TITLE", "FRAGMENT_TAG", "getFRAGMENT_TAG", "()Ljava/lang/String;", "KEY_NAME", "NUMBER_CARD", "newInstance", "Lcom/supercartoes/br/ui/customs/FingerprintDialog;", "title", "subtitle", "number", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFRAGMENT_TAG() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.supercartoes.br.ui.customs.FingerprintDialog newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String subtitle, @org.jetbrains.annotations.NotNull()
        java.lang.String number) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}