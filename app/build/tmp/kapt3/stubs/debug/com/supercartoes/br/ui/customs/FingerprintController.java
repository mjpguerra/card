package com.supercartoes.br.ui.customs;

import java.lang.System;

/**
 * * @author Mario Guerra on 10/07/2019
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0002./B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\u001a\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010#\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u001eJ\u000e\u0010\'\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u001eJ\u0012\u0010(\u001a\u00020\u001a2\b\u0010)\u001a\u0004\u0018\u00010\u001eH\u0002J\u000e\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/supercartoes/br/ui/customs/FingerprintController;", "Landroidx/core/hardware/fingerprint/FingerprintManagerCompat$AuthenticationCallback;", "fingerprintManager", "Landroidx/core/hardware/fingerprint/FingerprintManagerCompat;", "callback", "Lcom/supercartoes/br/ui/customs/FingerprintController$Callback;", "title", "Landroid/widget/TextView;", "subtitle", "errorText", "icon", "Landroid/widget/ImageView;", "(Landroidx/core/hardware/fingerprint/FingerprintManagerCompat;Lcom/supercartoes/br/ui/customs/FingerprintController$Callback;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/ImageView;)V", "cancellationSignal", "Landroidx/core/os/CancellationSignal;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "isFingerprintAuthAvailable", "", "()Z", "resetErrorTextRunnable", "Ljava/lang/Runnable;", "selfCancelled", "onAuthenticationError", "", "errMsgId", "", "errString", "", "onAuthenticationFailed", "onAuthenticationHelp", "helpMsgId", "helpString", "onAuthenticationSucceeded", "result", "Landroidx/core/hardware/fingerprint/FingerprintManagerCompat$AuthenticationResult;", "setSubtitle", "setTitle", "showError", "text", "startListening", "cryptoObject", "Landroidx/core/hardware/fingerprint/FingerprintManagerCompat$CryptoObject;", "stopListening", "Callback", "Companion", "app_debug"})
public final class FingerprintController extends androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback {
    
    /**
     * * The signal that gets called if the fingerprint authentication is cancelled.
     */
    private androidx.core.os.CancellationSignal cancellationSignal;
    
    /**
     * * Boolean flag for whether or not authentication was cancelled by this controller or something else.
     */
    private boolean selfCancelled;
    
    /**
     * * Runnable that resets the icon and error text as necessary.
     */
    private final java.lang.Runnable resetErrorTextRunnable = null;
    private final androidx.core.hardware.fingerprint.FingerprintManagerCompat fingerprintManager = null;
    private final com.supercartoes.br.ui.customs.FingerprintController.Callback callback = null;
    private final android.widget.TextView title = null;
    private final android.widget.TextView subtitle = null;
    private final android.widget.TextView errorText = null;
    private final android.widget.ImageView icon = null;
    private static final long ERROR_TIMEOUT_MILLIS = 1600L;
    private static final long SUCCESS_DELAY_MILLIS = 1300L;
    public static final com.supercartoes.br.ui.customs.FingerprintController.Companion Companion = null;
    
    private final boolean isFingerprintAuthAvailable() {
        return false;
    }
    
    private final android.content.Context getContext() {
        return null;
    }
    
    /**
     * * Begins listening for fingerprint authentication on the device.
     */
    public final void startListening(@org.jetbrains.annotations.NotNull()
    androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject cryptoObject) {
    }
    
    /**
     * * Cancels listening for fingerprint authentication. This should be done anytime your activity is killed, so that another app in the system can begin to check for the fingerprint.
     */
    public final void stopListening() {
    }
    
    /**
     * * Displays an error to the user if there was a problem with authentication.
     *     *
     *     * @param[text] The error message to show.
     */
    private final void showError(java.lang.CharSequence text) {
    }
    
    @java.lang.Override()
    public void onAuthenticationError(int errMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.CharSequence errString) {
    }
    
    @java.lang.Override()
    public void onAuthenticationSucceeded(@org.jetbrains.annotations.Nullable()
    androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationResult result) {
    }
    
    @java.lang.Override()
    public void onAuthenticationHelp(int helpMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.CharSequence helpString) {
    }
    
    @java.lang.Override()
    public void onAuthenticationFailed() {
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.CharSequence title) {
    }
    
    public final void setSubtitle(@org.jetbrains.annotations.NotNull()
    java.lang.CharSequence subtitle) {
    }
    
    public FingerprintController(@org.jetbrains.annotations.NotNull()
    androidx.core.hardware.fingerprint.FingerprintManagerCompat fingerprintManager, @org.jetbrains.annotations.NotNull()
    com.supercartoes.br.ui.customs.FingerprintController.Callback callback, @org.jetbrains.annotations.NotNull()
    android.widget.TextView title, @org.jetbrains.annotations.NotNull()
    android.widget.TextView subtitle, @org.jetbrains.annotations.NotNull()
    android.widget.TextView errorText, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView icon) {
        super();
    }
    
    /**
     * * A callback that allows a class to be updated when fingerprint authentication is complete.
     */
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/supercartoes/br/ui/customs/FingerprintController$Callback;", "", "onAuthenticated", "", "onError", "app_debug"})
    public static abstract interface Callback {
        
        public abstract void onAuthenticated();
        
        public abstract void onError();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/supercartoes/br/ui/customs/FingerprintController$Companion;", "", "()V", "ERROR_TIMEOUT_MILLIS", "", "SUCCESS_DELAY_MILLIS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}