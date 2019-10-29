package com.supercartoes.br.ui.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0012\u0010\u0007\u001a\u00020\u0003*\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u0016\u0010\u000b\u001a\u00020\f*\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u001aJ\u0010\u000f\u001a\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012\u001aL\u0010\u0015\u001a\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012\u001a\n\u0010\u0016\u001a\u00020\f*\u00020\u0017\u001a\u0012\u0010\u0018\u001a\u00020\f*\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a\u001a\n\u0010\u001b\u001a\u00020\u0003*\u00020\u001c\u001a\u001a\u0010\u001d\u001a\u00020\u001e*\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001e\u001a\u0012\u0010 \u001a\u00020\f*\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a\u001a\u001e\u0010!\u001a\u00020\u0003*\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030$\u001a\n\u0010%\u001a\u00020\f*\u00020\f\u001a\n\u0010&\u001a\u00020\f*\u00020\u0001\u001a\n\u0010\'\u001a\u00020\u0001*\u00020\u0017\u001a\n\u0010(\u001a\u00020\f*\u00020\u0017\u001a\n\u0010)\u001a\u00020\f*\u00020\u0017\u001a\n\u0010*\u001a\u00020\f*\u00020\u0017\u001a\n\u0010+\u001a\u00020\n*\u00020\f\u001a\u0012\u0010,\u001a\u00020\n*\u00020\u00172\u0006\u0010-\u001a\u00020\u0017\u001a\n\u0010.\u001a\u00020\n*\u00020\f\u001a\n\u0010/\u001a\u00020\n*\u00020\u0017\u001a\u0012\u00100\u001a\u00020\u0003*\u0002012\u0006\u00102\u001a\u000203\u001a\u0012\u00100\u001a\u00020\u0003*\u0002012\u0006\u00102\u001a\u00020\f\u001a\n\u00104\u001a\u00020\f*\u00020\u0017\u001a\n\u00105\u001a\u00020\f*\u00020\u0017\u001a\n\u00106\u001a\u00020\f*\u00020\u0017\u001a\n\u00107\u001a\u00020\u0003*\u00020\u0004\u001a\u0012\u00108\u001a\u00020\u0001*\u00020\u001a2\u0006\u00109\u001a\u00020\u001e\u001a\n\u0010:\u001a\u00020\f*\u00020\u0017\u001a\u0014\u0010;\u001a\u00020\u0003*\u00020\u001c2\b\u0010<\u001a\u0004\u0018\u00010\f\u001a\u0012\u0010=\u001a\u00020\u0003*\u00020>2\u0006\u0010?\u001a\u00020\u0004\u001a\u008f\u0002\u0010@\u001a\u00020\u0003*\u00020>2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010Q\u001a\u00020\n2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012\u00a2\u0006\u0002\u0010R\u001a\n\u0010S\u001a\u00020\u0003*\u00020T\u001a9\u0010U\u001a\u00020\u0003*\u00020>2\u0006\u0010V\u001a\u00020\f2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010Y\u001a\u00020\n\u00a2\u0006\u0002\u0010Z\u001a\u001a\u0010[\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\\\u001a\u00020\u00012\u0006\u0010]\u001a\u00020\u0001\u001a\u001a\u0010^\u001a\u00020\u0003*\u00020_2\u0006\u0010`\u001a\u0002012\u0006\u0010a\u001a\u00020\u0001\u001a\u0012\u0010^\u001a\u00020\u0003*\u00020_2\u0006\u0010a\u001a\u00020\u0001\u001a\n\u0010b\u001a\u00020\r*\u00020\f\u001a\n\u0010c\u001a\u00020\f*\u00020\u0017\u001a\n\u0010d\u001a\u00020\f*\u00020\f\u001a\u0012\u0010e\u001a\u00020\f*\u00020\u00172\u0006\u0010<\u001a\u00020\f\u001a\n\u0010f\u001a\u00020\f*\u00020\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006g"}, d2 = {"WRITE", "", "addButtonAnimation", "", "Landroid/view/View;", "changeVisibity", "visibility", "configLoader", "Landroid/widget/ProgressBar;", "colored", "", "currencyFormat", "", "", "currency", "customizeToolbar", "title", "back", "Lkotlin/Function0;", "close", "help", "customizeToolbarTitleString", "dayOfMonth", "Ljava/util/Date;", "decrypt", "context", "Landroid/content/Context;", "dismissKeyboard", "Landroid/widget/TextView;", "dpFromPx", "", "px", "encrypt", "forInChild", "Landroid/view/ViewGroup;", "event", "Lkotlin/Function1;", "formatDoc", "getResString", "getYearsOld", "hour", "hourMinute", "hourMinuteSecond", "isEmail", "isEqualsDay", "date", "isTelefone", "isToday", "loadUrl", "Landroid/widget/ImageView;", "url", "", "minute", "minuteSecond", "month", "preventDoubleClick", "pxFromDp", "dp", "second", "setErrorCuston", "string", "shareScreenShot", "Landroid/app/Activity;", "screenView", "showCustomDialog", "image", "subtitle", "yes", "no", "yesTitle", "noTitle", "subtitleString", "underText", "underTextAction", "yesDismissesDialog", "noDismissesDialog", "extraString", "cancel", "showClose", "dismissOutside", "titleString", "isRating", "(Landroid/app/Activity;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "showKeyboard", "Landroid/widget/EditText;", "showSB", "text", "view", "time", "isRed", "(Landroid/app/Activity;Ljava/lang/String;Landroid/view/View;Ljava/lang/Integer;Z)V", "sun", "quant", "period", "tint", "Landroid/graphics/drawable/Drawable;", "iv", "color", "toDoubleSD", "toFullDateTime", "toMd5", "toString", "year", "app_debug"})
public final class SDUtilKt {
    public static final int WRITE = 77;
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String currencyFormat(double $receiver, @org.jetbrains.annotations.Nullable()
    java.lang.String currency) {
        return null;
    }
    
    public static final void loadUrl(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $receiver, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    public static final void loadUrl(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $receiver, @org.jetbrains.annotations.NotNull()
    byte[] url) {
    }
    
    public static final void customizeToolbar(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver, int title, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> back, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> close, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> help) {
    }
    
    public static final void customizeToolbarTitleString(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver, @org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> back, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> close, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> help) {
    }
    
    public static final void addButtonAnimation(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getResString(int $receiver) {
        return null;
    }
    
    public static final void setErrorCuston(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $receiver, @org.jetbrains.annotations.Nullable()
    java.lang.String string) {
    }
    
    public static final int getYearsOld(@org.jetbrains.annotations.NotNull()
    java.util.Date $receiver) {
        return 0;
    }
    
    public static final void sun(@org.jetbrains.annotations.NotNull()
    java.util.Date $receiver, int quant, int period) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String toString(@org.jetbrains.annotations.NotNull()
    java.util.Date $receiver, @org.jetbrains.annotations.NotNull()
    java.lang.String string) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String hour(@org.jetbrains.annotations.NotNull()
    java.util.Date $receiver) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String minute(@org.jetbrains.annotations.NotNull()
    java.util.Date $receiver) {
        return null;
    }
    
    public static final boolean isToday(@org.jetbrains.annotations.NotNull()
    java.util.Date $receiver) {
        return false;
    }
    
    public static final boolean isEqualsDay(@org.jetbrains.annotations.NotNull()
    java.util.Date $receiver, @org.jetbrains.annotations.NotNull()
    java.util.Date date) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String second(@org.jetbrains.annotations.NotNull()
    java.util.Date $receiver) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String dayOfMonth(@org.jetbrains.annotations.NotNull()
    java.util.Date $receiver) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String month(@org.jetbrains.annotations.NotNull()
    java.util.Date $receiver) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String year(@org.jetbrains.annotations.NotNull()
    java.util.Date $receiver) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String minuteSecond(@org.jetbrains.annotations.NotNull()
    java.util.Date $receiver) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String hourMinute(@org.jetbrains.annotations.NotNull()
    java.util.Date $receiver) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String hourMinuteSecond(@org.jetbrains.annotations.NotNull()
    java.util.Date $receiver) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String toFullDateTime(@org.jetbrains.annotations.NotNull()
    java.util.Date $receiver) {
        return null;
    }
    
    public static final void showKeyboard(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $receiver) {
    }
    
    public static final void dismissKeyboard(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $receiver) {
    }
    
    public static final boolean isEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String $receiver) {
        return false;
    }
    
    public static final void showCustomDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity $receiver, @org.jetbrains.annotations.Nullable()
    java.lang.Integer image, @org.jetbrains.annotations.Nullable()
    java.lang.Integer title, @org.jetbrains.annotations.Nullable()
    java.lang.Integer subtitle, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> yes, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> no, @org.jetbrains.annotations.Nullable()
    java.lang.Integer yesTitle, @org.jetbrains.annotations.Nullable()
    java.lang.Integer noTitle, @org.jetbrains.annotations.Nullable()
    java.lang.String subtitleString, @org.jetbrains.annotations.Nullable()
    java.lang.Integer underText, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> underTextAction, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean yesDismissesDialog, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean noDismissesDialog, @org.jetbrains.annotations.Nullable()
    java.lang.String extraString, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> cancel, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean showClose, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean dismissOutside, @org.jetbrains.annotations.Nullable()
    java.lang.String titleString, boolean isRating, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> close) {
    }
    
    public static final void configLoader(@org.jetbrains.annotations.NotNull()
    android.widget.ProgressBar $receiver, boolean colored) {
    }
    
    public static final void tint(@org.jetbrains.annotations.NotNull()
    android.graphics.drawable.Drawable $receiver, int color) {
    }
    
    public static final void tint(@org.jetbrains.annotations.NotNull()
    android.graphics.drawable.Drawable $receiver, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView iv, int color) {
    }
    
    public static final float dpFromPx(@org.jetbrains.annotations.NotNull()
    android.content.Context $receiver, @org.jetbrains.annotations.NotNull()
    android.content.Context context, float px) {
        return 0.0F;
    }
    
    public static final int pxFromDp(@org.jetbrains.annotations.NotNull()
    android.content.Context $receiver, float dp) {
        return 0;
    }
    
    public static final void showSB(@org.jetbrains.annotations.NotNull()
    android.app.Activity $receiver, @org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.Nullable()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    java.lang.Integer time, boolean isRed) {
    }
    
    public static final void shareScreenShot(@org.jetbrains.annotations.NotNull()
    android.app.Activity $receiver, @org.jetbrains.annotations.NotNull()
    android.view.View screenView) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatDoc(@org.jetbrains.annotations.NotNull()
    java.lang.String $receiver) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String decrypt(@org.jetbrains.annotations.NotNull()
    java.lang.String $receiver, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String encrypt(@org.jetbrains.annotations.NotNull()
    java.lang.String $receiver, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public static final void preventDoubleClick(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver) {
    }
    
    public static final double toDoubleSD(@org.jetbrains.annotations.NotNull()
    java.lang.String $receiver) {
        return 0.0;
    }
    
    public static final void forInChild(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup $receiver, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> event) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String toMd5(@org.jetbrains.annotations.NotNull()
    java.lang.String $receiver) {
        return null;
    }
    
    public static final boolean isTelefone(@org.jetbrains.annotations.NotNull()
    java.lang.String $receiver) {
        return false;
    }
    
    public static final void changeVisibity(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver, int visibility) {
    }
}