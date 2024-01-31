package com.school.document.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DatetimeUtil {

    public static String formatDatetime(LocalDateTime dateTime){
        if (null == dateTime)
            return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy HH:mm", Locale.ENGLISH);

        // Format the LocalDateTime using the formatter
        return dateTime.format(formatter);
    }
}
