package org.example.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    public static Long getRemainingMonth(String expireDate) {
        LocalDate date = LocalDate.parse(expireDate);
        LocalDate now = LocalDate.now();

        return ChronoUnit.MONTHS.between(now, date);
    }
}
