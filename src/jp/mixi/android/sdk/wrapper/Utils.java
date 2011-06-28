package jp.mixi.android.sdk.wrapper;

import java.util.Calendar;
import java.util.Date;

import android.util.Log;

public class Utils {

    public static Date createDate(
            int year, int month, int date, int hour, int minute, int second) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, date);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        Log.w("Utils", cal.getTime().toString());
        return cal.getTime();
    }

}
