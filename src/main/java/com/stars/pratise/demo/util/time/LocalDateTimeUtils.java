package com.stars.pratise.demo.util.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/*
 * @author kingboy
 * @Date 2017/7/22 下午2:12
 * @Description LocalDateTimeUtils is used to Java8中的時間類
 */
public class LocalDateTimeUtils {

    //獲取當前時間的LocalDateTime對象
    //LocalDateTime.now();

    //根據年月日構建LocalDateTime
    //LocalDateTime.of();

    //比較日期先後
    //LocalDateTime.now().isBefore(),
    //LocalDateTime.now().isAfter(),


    /**
     * LocalDateTime 转 Date
     *
     * @param ldt LocalDateTime
     * @return Date
     */
    public static Date localDateTimeToDate(LocalDateTime ldt) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = ldt.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * Date 转 LocalDateTime
     *
     * @param date Date
     * @return LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * String 转 LocalDateTime
     *
     * @param str String
     * @return LocalDateTime
     */
    public static LocalDateTime stringToLocalDateTime(String str) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(str, dateTimeFormatter);
    }

    /**
     * LocalDateTime 转 String
     *
     * @param dt LocalDateTime
     * @return String
     */
    public static String localDateTimeToString(LocalDateTime dt) {
        return dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    //Date轉換為LocalDateTime
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    //LocalDateTime轉換為Date
    public static Date convertLDTToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }


    //獲取指定日期的毫秒
    public static Long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    //獲取指定日期的秒
    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    //獲取指定時間的指定格式
    public static String formatTime(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    //獲取當前時間的指定格式
    public static String formatNow(String pattern) {
        return formatTime(LocalDateTime.now(), pattern);
    }

    //日期加上一個數,根據field不同加不同值,field為ChronoUnit.*
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    //日期減去一個數,根據field不同減不同值,field參數為ChronoUnit.*
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field) {
        return time.minus(number, field);
    }

    /**
     * 獲取兩個日期的差  field參數為ChronoUnit.*
     *
     * @param startTime
     * @param endTime
     * @param field     單位(年月日時分秒)
     * @return
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) return period.getYears();
        if (field == ChronoUnit.MONTHS) return period.getYears() * 12 + period.getMonths();
        return field.between(startTime, endTime);
    }

    //獲取一天的開始時間，2017,7,22 00:00
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    //獲取一天的結束時間，2017,7,22 23:59:59.999999999
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999999);
    }

}