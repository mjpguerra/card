package com.supercartoes.br.repository;

import android.content.Context;
import android.content.SharedPreferences;
import com.supercartoes.br.R;
import org.jetbrains.annotations.NotNull;

/**
 * @author Mario Guerra on 10/07/2019
 */

public class AppPreferencesRegister {

    private static final String TOKEN_DEVICE = "token_device";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String CARD_NUMBER_STATE = "card_number_state";
    private static final String CARD_NUMBER = "card_number";
    private static final String HAS_PASS = "has_pass";
    private static final String PASSWORD_FOUR = "password_four";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private static final String SHOW_TOUCH_ID_STATE = "show_touch_id_state";
    private static final String IS_SHOWING_CURRENCY = "is_showing_currency";


    public AppPreferencesRegister(Context context) {
        if (preferences == null) {
            preferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
            editor = preferences.edit();
        }
    }

    public void saveNumberCardState(Boolean saveCpfState) {
        editor.putBoolean(CARD_NUMBER_STATE, saveCpfState);
        editor.commit();
    }

    public void saveNumberPhone(String phone) {
        editor.putString(PHONE_NUMBER, phone);
        editor.commit();
    }

    public void saveNumberCard(String card) {
        editor.putString(CARD_NUMBER, card);
        editor.commit();
    }

    public void saveShowTouchID(Boolean state) {
        editor.putBoolean(SHOW_TOUCH_ID_STATE, state);
        editor.commit();
    }

    public void saveTokenDevice(Boolean token) {
        editor.putBoolean(TOKEN_DEVICE, token);
        editor.commit();
    }

    public void saveShowCurrencyState(Boolean saveCpfState) {
        editor.putBoolean(IS_SHOWING_CURRENCY, saveCpfState);
        editor.commit();
    }

    public void setHasPass(@NotNull Boolean hasPass) {
        editor.putBoolean(HAS_PASS, hasPass);
        editor.commit();
    }

    public void savePassword(@NotNull String password) {
        editor.putString(PASSWORD_FOUR, password);
        editor.commit();
    }

    public String getPasswordFour() {
        return preferences.getString(PASSWORD_FOUR, "");
    }


    public Boolean hasPass() {
        return preferences.getBoolean(HAS_PASS, false);
    }

    public Boolean getNumberCardState() {
        return preferences.getBoolean(CARD_NUMBER_STATE, false);
    }

    public String getNumberPhone() {
        return preferences.getString(PHONE_NUMBER, "");
    }

    public String getNumberCard() {
        return preferences.getString(CARD_NUMBER, "");
    }

    public Boolean getShowTouchID() {
        return preferences.getBoolean(SHOW_TOUCH_ID_STATE, true);
    }

    public Boolean getTokenDevice() {
        return preferences.getBoolean(TOKEN_DEVICE, false);
    }

    public Boolean getShowingCurrencyState() {
        return preferences.getBoolean(IS_SHOWING_CURRENCY, true);
    }

    public void clearAll() {
        editor.clear();
        editor.commit();
    }

}
