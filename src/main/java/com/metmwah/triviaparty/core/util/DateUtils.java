package com.metmwah.triviaparty.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        return FORMATTER.format(date);
    }
}
