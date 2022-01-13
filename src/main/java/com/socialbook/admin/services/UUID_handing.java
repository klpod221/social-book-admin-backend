package com.socialbook.admin.services;

import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class UUID_handing {
    private static String created_time = "2001-12-17 00:00:00.000000";
    private static String time_zone = "Asia/Ho_Chi_Minh";
    private static String datetime_default_format = "yyyy-MM-dd HH:mm:ss.SSSSSS";

    private static Long created_nanotime() throws ParseException {
        Long time = new SimpleDateFormat(datetime_default_format).parse(created_time).getTime();
        return time;
    }

    private static Long timenow_nanotime() throws ParseException {
        Instant instant = Clock.system(ZoneId.of(time_zone)).instant();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datetime_default_format)
                .withZone(ZoneId.of(time_zone));
        String time_now = formatter.format(instant);

        Long time = new SimpleDateFormat(datetime_default_format).parse(time_now).getTime();
        return time;
    }

    public static Long UUID_Generator() throws ParseException {
        Long UUID;
        UUID = timenow_nanotime() - created_nanotime();
        return UUID << 19;
    }

    // public static void main(String[] args) throws ParseException {
    // Long UUID = UUID_Generator();
    // System.out.println(UUID);
    // }
}
