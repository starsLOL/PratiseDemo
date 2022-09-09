package com.stars.pratise.demo.util.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 基于java8封装的时间处理工具类
 *
 * @author LGQ
 */
public class DateUtilsThree {

    public static DateTimeFormatter formatDataTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static LocalDateTime localDateTime = LocalDateTime.now();
    public static LocalTime localTime = LocalTime.now();
    public static LocalDate localDate = LocalDate.now();

    /**
     * 获取秒级时间戳
     */
    public static Long epochSecond = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));

    /**
     * 获取毫秒级时间戳
     */
    public static Long epochMilli = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

    /**
     * 获取当前详细时间，like 2018-08-27 17:20:06
     */
    public static String dateTime = localDateTime.format(formatDataTime);

    /**
     * 获取当前日期，like 2018-08-27
     */
    public static String date = LocalDate.now() + "";

    /**
     * 获取当前时间，like 17:20:06
     */
    public static String time = localTime.format(formatTime);

    /**
     * 获取当前年
     */
    public static int year = localDate.getYear();


    /**
     * 昨天的开始时间
     *
     * @return
     */
    public static LocalDateTime yesterdayDateBegin() {
        LocalDate currentTime = LocalDate.now();
        LocalDate yesterday = currentTime.plusDays(-1);
        return LocalDateTime.of(yesterday, LocalTime.MIN);
    }

    /**
     * 昨天的结束时间
     *
     * @return
     */
    public static LocalDateTime yesterdayDateEnd() {
        LocalDate currentTime = LocalDate.now();
        LocalDate yesterday = currentTime.plusDays(-1);
        return LocalDateTime.of(yesterday, LocalTime.MAX);
    }

    /**
     * 获取当前年的前几年/后几年的日期
     * <p>
     *
     * @param yearsToAddOrSubtract 后几年传正整数，前几年传负数
     * @param formatter
     */
    public static String getMinusOrPlusYears(long yearsToAddOrSubtract, DateTimeFormatter formatter) {
        String date = formatter.equals(formatDataTime) ? localDateTime.plusYears(yearsToAddOrSubtract).format(formatter) :
                localDate.plusYears(yearsToAddOrSubtract) + "";
        return date;
    }

    /**
     * 获取当前月
     */
    public static int month = localDate.getMonthValue();

    /**
     * 获取当前月的前几月/后几月的日期
     *
     * @param monthsToAddOrSubtract 后几月传正整数，前几月传负数
     * @param formatter
     */
    public static String getMinusOrPlusMonths(long monthsToAddOrSubtract, DateTimeFormatter formatter) {
        String date = formatter.equals(formatDataTime) ? localDateTime.plusMonths(monthsToAddOrSubtract).format(formatter) :
                localDate.plusMonths(monthsToAddOrSubtract) + "";
        return date;
    }

    /**
     * 获取当前年中的日
     */
    public static int dayOfYear = localDate.getDayOfYear();

    /**
     * 获取当前月中的日
     */
    public static int dayOfMonth = localDate.getDayOfMonth();


    /**
     * 获取当前日的前几日/后几日的日期
     *
     * @param daysToAddOrSubtract 后几日传正整数，前几日传负数
     * @param formatter
     */
    public static String getMinusOrPlusDays(long daysToAddOrSubtract, DateTimeFormatter formatter) {
        String date = formatter.equals(formatDataTime) ? localDateTime.plusDays(daysToAddOrSubtract).format(formatter) :
                localDate.plusDays(daysToAddOrSubtract) + "";
        return date;
    }

    /**
     * 获取当前星期中的日
     */
    public static int dayOfWeek = localDate.getDayOfWeek().getValue();

    /**
     * 获取当前星期的前几星期/后几星期的日期
     *
     * @param weeksToAddOrSubtract 后几星期传正整数，前几星期传负数
     * @param formatter
     */
    public static String getMinusOrPlusWeeks(long weeksToAddOrSubtract, DateTimeFormatter formatter) {
        String date = formatter.equals(formatDataTime) ? localDateTime.plusWeeks(weeksToAddOrSubtract).format(formatter) :
                localDate.plusWeeks(weeksToAddOrSubtract) + "";
        return date;
    }

    /**
     * 获取当前小时
     */
    public static int hour = localTime.getHour();

    /**
     * 获取当前小时的前几小时/后几小时的日期
     *
     * @param hoursToAddOrSubtract 后几小时传正整数，前几小时传负数
     * @param formatter
     */
    public static String getMinusOrPlusHours(long hoursToAddOrSubtract, DateTimeFormatter formatter) {
        String date = formatter.equals(formatDataTime) ? localDateTime.plusHours(hoursToAddOrSubtract).format(formatter) :
                localTime.plusHours(hoursToAddOrSubtract).format(formatter);
        return date;
    }

    /**
     * 获取当前分钟
     */
    public static int minute = localTime.getMinute();

    /**
     * 获取当前分钟的前几分钟/后几分钟的日期
     *
     * @param minutesToAddOrSubtract 后几分钟传正整数，前几分钟传负数
     * @param formatter
     */
    public static String getMinusOrPlusMinutes(long minutesToAddOrSubtract, DateTimeFormatter formatter) {
        String date = formatter.equals(formatDataTime) ? localDateTime.plusMinutes(minutesToAddOrSubtract).format(formatter) :
                localTime.plusMinutes(minutesToAddOrSubtract).format(formatter);
        return date;
    }

    /**
     * 获取当前秒
     */
    public static int second = localTime.getSecond();

    /**
     * 获取当前秒的前几秒/后几秒的日期
     *
     * @param secondsToAddOrSubtract 后几秒传正整数，前几秒传负数
     * @param formatter
     */
    public static String getMinusOrPlusSeconds(long secondsToAddOrSubtract, DateTimeFormatter formatter) {
        String date = formatter.equals(formatDataTime) ? localDateTime.plusSeconds(secondsToAddOrSubtract).format(formatter) :
                localTime.plusSeconds(secondsToAddOrSubtract).format(formatter);
        return date;
    }

    /**
     * Date类型转LocalDateTime、LocalDate、LocalTime
     * <p>
     *
     * @param date
     * @param type 1:LocalDateTime; 2:LocalDate; 3: LocalTime
     */
    public static Object DateToJava8Date(Date date, Integer type) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, zone);
        Object java8Date = null;
        switch (type) {
            case 1:
                java8Date = dateTime;
                break;
            case 2:
                java8Date = dateTime.toLocalDate();
                break;
            case 3:
                java8Date = dateTime.toLocalTime();
                break;
        }
        return java8Date;
    }


    /**
     * LocalDateTime、LocalDate、LocalTime类型转Date
     * <p>
     *
     * @param java8Date LocalDateTime、LocalDate、LocalTime
     */
    public static Date Java8DateToDate(Object java8Date) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = null;
        if (java8Date instanceof LocalDateTime) {
            instant = localDateTime.atZone(zone).toInstant();
        }
        if (java8Date instanceof LocalDate) {
            instant = localDate.atStartOfDay().atZone(zone).toInstant();
        }
        if (java8Date instanceof LocalTime) {
            LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
            instant = localDateTime.atZone(zone).toInstant();
        }
        return instant == null ? null : Date.from(instant);
    }

}
