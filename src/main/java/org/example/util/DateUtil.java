package org.example.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    public static Long getRemainingMonth(String expireDate) {
        LocalDate date = LocalDate.parse(expireDate);
        LocalDate now = LocalDate.now();

        return ChronoUnit.MONTHS.between(now, date);
    }

    /**
     * Input: date = "20th Oct 2052"
     * Output: "2052-10-20"
     **/
    public String reformatDate(String date) {
        String[] strArr = date.split(" ");
        return strArr[2] + '-' +
                getMonth(strArr[1]) + '-' +
                getDay(strArr[0]);
    }

    private String getDay(String dayStr) {
        String day = dayStr.substring(0, dayStr.length() - 2);
        if (dayStr.length() == 3) {
            return "0" + day;
        } else {
            return day;
        }
    }

    private String getMonth(String monthStr) {
        return switch (monthStr) {
            case "Jan" -> "01";
            case "Feb" -> "02";
            case "Mar" -> "03";
            case "Apr" -> "04";
            case "May" -> "05";
            case "Jun" -> "06";
            case "Jul" -> "07";
            case "Aug" -> "08";
            case "Sep" -> "09";
            case "Oct" -> "10";
            case "Nov" -> "11";
            case "Dec" -> "12";
            default -> "0";
        };
    }
}
