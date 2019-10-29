package com.supercartoes.br.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u00a8\u0006\u0016"}, d2 = {"Lcom/supercartoes/br/utils/SystemUtil;", "", "()V", "disableAccelerometerListening", "", "activity", "Landroid/app/Activity;", "sensorEventListener", "Landroid/hardware/SensorEventListener;", "enableAccelerometerListening", "getWindowSize", "", "context", "Landroid/content/Context;", "hideKeyboard", "mView", "Landroid/view/View;", "showKeyboard", "Lcom/supercartoes/br/ui/activities/LoginActivity;", "edittext", "Landroid/widget/EditText;", "vibrateDevice", "app_debug"})
public final class SystemUtil {
    public static final com.supercartoes.br.utils.SystemUtil INSTANCE = null;
    
    public final void vibrateDevice(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void disableAccelerometerListening(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    android.hardware.SensorEventListener sensorEventListener) {
    }
    
    public final void enableAccelerometerListening(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    android.hardware.SensorEventListener sensorEventListener) {
    }
    
    public final void hideKeyboard(@org.jetbrains.annotations.Nullable()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    android.view.View mView) {
    }
    
    public final void showKeyboard(@org.jetbrains.annotations.Nullable()
    com.supercartoes.br.ui.activities.LoginActivity activity, @org.jetbrains.annotations.Nullable()
    android.widget.EditText edittext) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final int[] getWindowSize(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    private SystemUtil() {
        super();
    }
}