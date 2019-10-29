package com.supercartoes.br.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0011J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010\'\u001a\u0004\u0018\u00010\u000f2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010,\u001a\u00020\u001cH\u0002J\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0011J\u0010\u0010/\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/supercartoes/br/ui/fragments/PasswordCardFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/supercartoes/br/ui/fragments/PasswordComponentFragment$OnFragmentPasswordListener;", "()V", "etPassword", "Landroid/widget/EditText;", "getEtPassword", "()Landroid/widget/EditText;", "setEtPassword", "(Landroid/widget/EditText;)V", "fingerprintManager", "Landroidx/core/hardware/fingerprint/FingerprintManagerCompat;", "llContainerForComponentPassword", "Landroid/widget/FrameLayout;", "mView", "Landroid/view/View;", "numberCard", "", "getNumberCard", "()Ljava/lang/String;", "setNumberCard", "(Ljava/lang/String;)V", "preferencesRegister", "Lcom/supercartoes/br/repository/AppPreferencesRegister;", "tvFingerPrint", "Landroid/widget/TextView;", "tvForgotPassword", "addNext", "", "fingerprintAvailable", "", "initFp", "initiFingerprintDialog", "libLogin", "password", "onCharacterPasswordFragmentPassword", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "removeNext", "savePass", "pass", "validateField", "Companion", "app_debug"})
public final class PasswordCardFragment extends androidx.fragment.app.Fragment implements com.supercartoes.br.ui.fragments.PasswordComponentFragment.OnFragmentPasswordListener {
    private com.supercartoes.br.repository.AppPreferencesRegister preferencesRegister;
    private androidx.core.hardware.fingerprint.FingerprintManagerCompat fingerprintManager;
    private android.widget.FrameLayout llContainerForComponentPassword;
    private android.view.View mView;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText etPassword;
    private android.widget.TextView tvFingerPrint;
    private android.widget.TextView tvForgotPassword;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String numberCard;
    public static final com.supercartoes.br.ui.fragments.PasswordCardFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getEtPassword() {
        return null;
    }
    
    public final void setEtPassword(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNumberCard() {
        return null;
    }
    
    public final void setNumberCard(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    public void onCharacterPasswordFragmentPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    android.widget.EditText etPassword) {
    }
    
    public final void addNext() {
    }
    
    private final boolean validateField(android.widget.EditText etPassword) {
        return false;
    }
    
    public final void libLogin(@org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    private final void removeNext() {
    }
    
    private final void initiFingerprintDialog() {
    }
    
    private final boolean fingerprintAvailable() {
        return false;
    }
    
    public final void savePass(@org.jetbrains.annotations.NotNull()
    java.lang.String pass) {
    }
    
    private final void initFp() {
    }
    
    public PasswordCardFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.supercartoes.br.ui.fragments.PasswordCardFragment newInstance() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/supercartoes/br/ui/fragments/PasswordCardFragment$Companion;", "", "()V", "newInstance", "Lcom/supercartoes/br/ui/fragments/PasswordCardFragment;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.supercartoes.br.ui.fragments.PasswordCardFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}