package com.stars.pratise.demo.util.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Desc: java8日期工具类 (包括LocalDate,LocalDateTime,Date)
 * @Author: liuxw
 * @Date: 2021-02-06 10:18
 **/
public class DateTimeUtilFour {

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyyMMddHHmmss
     */
    public static final String DATE_FORMAT_FULL_CODE = "yyyyMMddHHmmss";

    /**
     * yyyy/MM/dd HH:mm:ss
     */
    public static final String DATE_FORMAT_FULL_SLASH = "yyyy/MM/dd HH:mm:ss";

    /**
     * yyyy-MM-dd
     */
    public static final String DATE_FORMAT_YMD = "yyyy-MM-dd";

    /**
     * yyyy/MM/dd
     */
    public static final String DATE_FORMAT_YMD_SLASH = "yyyy/MM/dd";

    /**
     * yyyyMMdd
     */
    public static final String DATE_FORMAT_YMD_CODE = "yyyyMMdd";

    /**
     * yyyy-MM
     */
    public static final String DATE_FORMAT_YYMM = "yyyy-MM";

    /**
     * yyyy/MM
     */
    public static final String DATE_FORMAT_YYMM_SLASH = "yyyy/MM";

    /**
     * yyyy
     */
    public static final String DATE_FORMAT_YY = "yyyy";

    /**
     * MM
     */
    public static final String DATE_FORMAT_MM = "MM";

    /**
     * HH:mm:ss
     */
    public static final String DATE_FORMAT_HMS = "HH:mm:ss";

    /**
     * HH:mm
     */
    public static final String DATE_FORMAT_HHMM = "HH:mm";

    /**
     * HH
     */
    public static final String DATE_FORMAT_HH = "HH";


    /**
     * 获得今日日期 HH:mm:ss格式字符串
     *
     * @return String
     */
    public static String getTodayHMS() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_FORMAT_HMS);
        LocalDateTime today = LocalDateTime.now();
        String nowDate = today.format(df);
        return nowDate;
    }

    /**
     * 获得今日日期 yyyy-MM-dd格式字符串
     *
     * @return String
     */
    public static String getToday() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_FORMAT_YMD);
        LocalDateTime today = LocalDateTime.now();
        String nowDate = today.format(df);
        return nowDate;
    }

    /**
     * 获得当前日期时间 yyyy-MM-dd HH:mm:ss格式字符串
     *
     * @return String
     */
    public static String getCurrentDateTime() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_FORMAT_FULL);
        LocalDateTime dateTime = LocalDateTime.now();
        String nowDateTime = dateTime.format(df);
        return nowDateTime;
    }

    /**
     * 获取当天开始时间 2019-06-12 00:00:00 LocalDateTime类型
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getTodayBeginTime() {
        LocalDate currentDay = LocalDate.now();
        return LocalDateTime.of(currentDay, LocalTime.MIN);
    }

    /**
     * 获取当天结束时间 2019-06-12 23:59:59
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getTodayEndTime() {
        LocalDate currentDay = LocalDate.now();
        return LocalDateTime.of(currentDay, LocalTime.MAX);
    }

    /**
     * LocalDate转化为指定格式字符串
     *
     * @param fromDate
     * @param dateFormat yyyy-MM-dd | yyyy/MM/dd | yyyyMMdd | yyyy-MM | yyyy/MM | yyyyMM
     * @return
     */
    public static String localDate2Str(LocalDate fromDate, String dateFormat) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(dateFormat);
        String dateStr = fromDate.format(df);
        return dateStr;
    }

    /**
     * LocalDateTime转化为指定格式字符串
     *
     * @param fromDateTime
     * @param dateTimeFotmat yyyy-MM-dd HH:mm:ss | yyyy/MM/dd HH:mm:ss | yyyyMMdd HH:mm:ss | ...
     * @return
     */
    public static String localDateTime2Str(LocalDateTime fromDateTime, String dateTimeFotmat) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(dateTimeFotmat);
        String localTime = fromDateTime.format(df);
        return localTime;
    }

    /**
     * 日期格式字符串转化为指定格式的LocalDate日期
     *
     * @param beginDate  yyyy-MM-dd | yyyy/MM/dd | yyyyMMdd
     * @param dateFormat yyyy-MM-dd | yyyy/MM/dd | yyyyMMdd
     * @return
     */
    public static LocalDate str2LocalDate(String beginDate, String dateFormat) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(dateFormat);
        try {
            LocalDate fromDate = LocalDate.parse(beginDate, df);
            return fromDate;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 时间格式字符串转化为指定格式的LocalDateTime时间
     *
     * @param beginDateTime yyyy-MM-dd HH:mm:ss | yyyy/MM/dd HH:mm:ss | yyyyMMdd HH:mm:ss
     * @param dateFormat    yyyy-MM-dd HH:mm:ss | yyyy/MM/dd HH:mm:ss | yyyyMMdd HH:mm:ss
     * @return
     */
    public static LocalDateTime str2LocalDateTime(String beginDateTime, String dateFormat) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(dateFormat);
        try {
            LocalDateTime fromDateTime = LocalDateTime.parse(beginDateTime, df);
            return fromDateTime;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Date转为LocalDateTime
     *
     * @param date Date类型
     * @return LocalDateTime
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * Long类型时间戳转化为LocalDateTime
     *
     * @param dateTimeLong 毫秒数
     * @return LocalDateTime
     */
    public static LocalDateTime long2LocalDateTime(Long dateTimeLong) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(dateTimeLong), ZoneId.systemDefault());
        return dateTime;
    }

    /**
     * 日期时间str转为日期str (yyyy-MM-dd HH:mm:ss -> yyyy-MM-dd)
     *
     * @param fullDate yyyy-MM-dd HH:mm:ss格式字符串
     * @return yyyy-MM-dd格式字符串
     */
    public static String fullDate2Date(String fullDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_FORMAT_FULL);
        LocalDate localDate = LocalDateTime.parse(fullDate, df).toLocalDate();
        return localDate2Str(localDate, DATE_FORMAT_YMD);
    }

    /**
     * 日期格式转换
     *
     * @param day  年月日格式字符串
     * @param fmt1 当前格式 yyyy-MM-dd | yyyy/MM/dd | yyyyMMdd
     * @param fmt2 期望转换的格式 yyyy-MM-dd | yyyy/MM/dd | yyyyMMdd
     * @return String
     */
    public static String dateFormatConvert(String day, String fmt1, String fmt2) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(fmt2);
        return str2LocalDate(day, fmt1).format(dtf);
    }

    /**
     * 日期时间格式转换
     *
     * @param dayTime 年月日时分秒格式字符串
     * @param fmt1    当前格式 yyyy-MM-dd HH:mm:ss | yyyy/MM/dd HH:mm:ss | yyyyMMddHHmmss
     * @param fmt2    期望转换的格式 yyyy-MM-dd HH:mm:ss | yyyy/MM/dd HH:mm:ss | yyyyMMddHHmmss
     * @return String
     */
    public static String dateTimeFormatConvert(String dayTime, String fmt1, String fmt2) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(fmt2);
        return str2LocalDateTime(dayTime, fmt1).format(dtf);
    }

    /**
     * 日期加减天数
     *
     * @param day yyyy-MM-dd格式字符串
     * @param d   整数(正为加,负为减)
     * @return String
     */
    public static String addDays(String day, int d) {
        LocalDate localDate = str2LocalDate(day, DATE_FORMAT_YMD).plusDays(d);
        return localDate2Str(localDate, DATE_FORMAT_YMD);
    }

    /**
     * 日期时间加减天数
     *
     * @param dayTime yyyy-MM-dd HH:mm:ss格式字符串
     * @param d       天数(正为加,负为减)
     * @return String
     */
    public static String addTimeDays(String dayTime, int d) {
        LocalDateTime localDateTime = str2LocalDateTime(dayTime, DATE_FORMAT_FULL).plusDays(d);
        return localDateTime2Str(localDateTime, DATE_FORMAT_FULL);
    }

    /**
     * 时间加减分钟数
     *
     * @param dayTime yyyy-MM-dd HH:mm:ss格式字符串
     * @param min     分钟数(正为加,负为减)
     * @return String
     */
    public static String addMinutes(String dayTime, long min) {
        LocalDateTime localDateTime = str2LocalDateTime(dayTime, DATE_FORMAT_FULL).plusMinutes(min);
        return localDateTime2Str(localDateTime, DATE_FORMAT_FULL);
    }

    /**
     * 日期加减周数 获取某日前几周或后几周的日期
     *
     * @param day  yyyy-MM-dd格式字符串
     * @param week 周数(正为加,负为减)
     * @return String
     */
    public static String addWeeks(String day, long week) {
        LocalDate localDate = str2LocalDate(day, DATE_FORMAT_YMD).plusWeeks(week);
        return localDate2Str(localDate, DATE_FORMAT_YMD);
    }

    /**
     * 日期加减月数
     *
     * @param day   yyyy-MM-dd格式字符串
     * @param month 月数(正为加,负为减)
     * @return String
     */
    public static String addMonths(String day, long month) {
        LocalDate localDate = str2LocalDate(day, DATE_FORMAT_YMD).plusMonths(month);
        return localDate2Str(localDate, DATE_FORMAT_YMD);
    }

    /**
     * 日期加减年数
     *
     * @param day  yyyy-MM-dd格式字符串
     * @param year 年数(正为加,负为减)
     * @return String
     */
    public static String addYears(String day, long year) {
        LocalDate localDate = str2LocalDate(day, DATE_FORMAT_YMD).plusYears(year);
        return localDate2Str(localDate, DATE_FORMAT_YMD);
    }

    /**
     * 获取两日期的间隔天数
     *
     * @param start yyyy-MM-dd格式字符串
     * @param end   yyyy-MM-dd格式字符串
     * @return long
     */
    public static long getDaysInterval(String start, String end) {
        return (str2LocalDate(end, DATE_FORMAT_YMD).toEpochDay() - str2LocalDate(start, DATE_FORMAT_YMD).toEpochDay());
    }

    /**
     * 获取两日期时间的间隔秒数
     *
     * @param start yyyy-MM-dd HH:mm:ss格式字符串
     * @param end   yyyy-MM-dd HH:mm:ss格式字符串
     * @return long
     */
    public static long getSecondsInterval(String start, String end) {
        Duration between = Duration.between(str2LocalDateTime(start, DATE_FORMAT_FULL), str2LocalDateTime(end, DATE_FORMAT_FULL));
        return between.getSeconds();
    }

    /**
     * 获取两个日期间隔的所有日期
     *
     * @param start yyyy-MM-dd格式字符串
     * @param end   yyyy-MM-dd格式字符串
     * @return List<String>
     */
    public static List<String> getDayArrayBetween(String start, String end) {
        List<String> list = new ArrayList<>();
        LocalDate localDateStart = str2LocalDate(start, DATE_FORMAT_YMD);
        LocalDate localDate1End = str2LocalDate(end, DATE_FORMAT_YMD);
        long distance = ChronoUnit.DAYS.between(localDateStart, localDate1End);
        if (distance < 1)
            return list;
        Stream.iterate(localDateStart, d -> d.plusDays(1)).limit(distance + 1).forEach(x -> list.add(localDate2Str(x, DATE_FORMAT_YMD)));
        return list;
    }

    /**
     * 获取日期一定范围内的所有日期
     *
     * @param day   yyyy-MM-dd格式字符串
     * @param range 负数代表前几天  正数代表后几天
     * @return List<String>
     */
    public static List<String> getDayArrayRange(String day, int range) {
        List<String> list = new ArrayList<>();
        LocalDate localDateStart = str2LocalDate(day, DATE_FORMAT_YMD);
        LocalDate localDate1End = str2LocalDate(addDays(day, range), DATE_FORMAT_YMD);
        if (range > 0) {
            long distance = ChronoUnit.DAYS.between(localDateStart, localDate1End);
            if (distance < 1)
                return list;
            Stream.iterate(localDateStart, d -> d.plusDays(1)).limit(distance + 1).forEach(x -> list.add(localDate2Str(x, DATE_FORMAT_YMD)));
            return list;
        } else {
            long distance = ChronoUnit.DAYS.between(localDate1End, localDateStart);
            if (distance < 1)
                return list;
            Stream.iterate(localDateStart, d -> d.minusDays(1)).limit(distance + 1).forEach(x -> list.add(localDate2Str(x, DATE_FORMAT_YMD)));
            Collections.reverse(list);
            return list;
        }
    }

    /**
     * 日期时间比较大小
     *
     * @param start yyyy-MM-dd HH:mm:ss格式字符串
     * @param end   yyyy-MM-dd HH:mm:ss格式字符串
     * @return true: start > end | false: start < end
     */
    public static boolean compareDateTime(String start, String end) {
        return str2LocalDateTime(start, DATE_FORMAT_FULL).isAfter(str2LocalDateTime(end, DATE_FORMAT_FULL));
    }

    /**
     * 日期比较大小
     *
     * @param start yyyy-MM-dd格式字符串
     * @param end   yyyy-MM-dd格式字符串
     * @return true: start > end | false: start < end
     */
    public static boolean compareDate(String start, String end) {
        return str2LocalDate(start, DATE_FORMAT_YMD).isAfter(str2LocalDate(end, DATE_FORMAT_YMD));
    }

    /**
     * 获得一年后的日期字符串
     */
    public static String getOneYearLaterDate(String beginDate, String dateFormat) {
        LocalDate fromDate = str2LocalDate(beginDate, dateFormat);
        if (fromDate != null) {
            LocalDate toDate = fromDate.plus(1, ChronoUnit.YEARS);
            return localDate2Str(toDate, dateFormat);
        }
        return null;
    }

    /**
     * 获得一年后的日期时间字符串
     */
    public static String getOneYearLaterDateTime(String beginDate, String dateFormat) {
        LocalDateTime fromDate = str2LocalDateTime(beginDate, dateFormat);
        if (fromDate != null) {
            LocalDateTime toDate = fromDate.plus(1, ChronoUnit.YEARS);
            return localDateTime2Str(toDate, dateFormat);
        }
        return null;
    }

    /**
     * 获取本周第一天(周一) yyyy-MM-dd格式字符串
     *
     * @return String
     */
    public static String getFirstDayOfCurrentWeek() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_FORMAT_YMD);
        LocalDate d1 = LocalDate.now().plusWeeks(0).with(DayOfWeek.MONDAY);
        String nowDate = d1.format(df);
        return nowDate;
    }

    /**
     * 获取本周开始时间 2019-06-10 00:00:00 LocalDateTime类型
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getWeekBeginTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        int currentOrdinal = currentDateTime.getDayOfWeek().ordinal();
        return currentDateTime.minusDays(currentOrdinal)
                .withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    /**
     * 获取本周最后一天(周日) yyyy-MM-dd格式字符串
     *
     * @return String
     */
    public static String getLastDayOfCurrentWeek() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_FORMAT_YMD);
        LocalDate d2 = LocalDate.now().plusWeeks(0).with(DayOfWeek.SUNDAY);
        String nowDate = d2.format(df);
        return nowDate;
    }

    /**
     * 获取本周结束时间 2019-06-16 23:59:59
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getWeekEndTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        int currentOrdinal = currentDateTime.getDayOfWeek().ordinal();
        return currentDateTime.plusDays(6 - currentOrdinal)
                .withHour(23).withMinute(59).withSecond(59).withNano(999999999);
    }

    /**
     * 获取本周 周几所在的日期 yyyy-MM-dd格式字符串
     *
     * @return String
     * @desc 参数w值范围1~7, 如：w=2 返回本周周二的日期
     */
    public static String getWeekDay(int w) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_FORMAT_YMD);
        LocalDate d2 = LocalDate.now().plusWeeks(0).with(DayOfWeek.of(w));
        return d2.format(df);
    }

    /**
     * 返回今天是周几
     *
     * @return 1 | 2 | 3 | 4 | 5 | 6 | 7
     */
    public static Integer getTodayIndexOfWeek() {
        return LocalDate.now().getDayOfWeek().getValue();
    }

    /**
     * 返回某日是周几
     *
     * @param day yyyy-MM-dd格式
     * @return 1 | 2 | 3 | 4 | 5 | 6 | 7
     */
    public static Integer getDayIndexOfWeek(String day) {
        return str2LocalDate(day, DATE_FORMAT_YMD).getDayOfWeek().getValue();
    }

    /**
     * 返回本周周一至周日日期数组
     *
     * @return [yyyy-MM-dd, ... ,yyyy-MM-dd]
     */
    public static List<String> getArrayOfCurrentWeek() {
        List<String> list = new ArrayList<>();
        Stream.iterate(1, n -> n + 1).limit(7).forEach(x -> list.add(getWeekDay(x)));
        return list;
    }

    /**
     * 返回本周周一至今日日期数组
     *
     * @return [yyyy-MM-dd, ... ,yyyy-MM-dd]
     */
    public static List<String> getTodayArrayOfCurrentWeek() {
        List<String> list = new ArrayList<>();
        Integer week = LocalDate.now().getDayOfWeek().getValue();
        Stream.iterate(1, n -> n + 1).limit(week).forEach(x -> list.add(getWeekDay(x)));
        return list;
    }

    /**
     * 获取本月第一天 yyyy-MM-dd格式字符串
     *
     * @return
     */
    public static String getFirstDayOfCurrentMonth() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_FORMAT_YMD);
        LocalDate first = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        String date = first.format(df);
        return date;
    }

    /**
     * 获取本月最后一天 yyyy-MM-dd格式字符串
     *
     * @return
     */
    public static String getLastDayOfCurrentMonth() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_FORMAT_YMD);
        LocalDate last = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        String date = last.format(df);
        return date;
    }

    /**
     * 获取本年第一天 yyyy-MM-dd格式字符串
     *
     * @return
     */
    public static String getFirstDayOfCurrentYear() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_FORMAT_YMD);
        LocalDate first = LocalDate.now().plusYears(0).with(TemporalAdjusters.firstDayOfYear());
        String date = first.format(df);
        return date;
    }

    /**
     * 获取本年最后一天 yyyy-MM-dd格式字符串
     *
     * @return
     */
    public static String getLastDayOfCurrentYear() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_FORMAT_YMD);
        LocalDate last = LocalDate.now().plusYears(0).with(TemporalAdjusters.lastDayOfYear());
        String date = last.format(df);
        return date;
    }

    /**
     * 获得毫秒数
     *
     * @param localDateTime
     * @return
     */
    public static long getTimestampOfDateTime(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * 根据出生日期(yyyy-MM-dd)字符串计算年龄
     *
     * @param birthDay
     * @return
     */
    public static Integer getAgeByBirthDay(String birthDay) {
        LocalDate birthDate = str2LocalDate(birthDay, DATE_FORMAT_YMD);
        LocalDate currentDate = LocalDate.now();
        if (birthDate != null) {
            if (currentDate.isBefore(birthDate))
                return 0;
            else
                return birthDate.until(currentDate).getYears();
        }
        return null;
    }

    /**
     * 判断闰年平年
     * 闰年算法: 四年一闰,百年不闰,四百年再闰
     *
     * @param year yyyy-MM-dd格式字符串
     * @return true闰年 | false平年
     */
    public static boolean checkLeapYear(String year) {
        return str2LocalDate(year, DATE_FORMAT_YMD).isLeapYear();
    }

    /**
     * 获取当前日期所在季度的开始日期 或 结束日期
     * 一年四季, 第一季度：1月-3月, 第二季度：4月-6月, 第三季度：7月-9月, 第四季度：10月-12月
     *
     * @param first true表示查询本季度开始日期  false表示查询本季度结束日期
     * @return
     */
    public static LocalDate getStartOrEndDayOfQuarter(boolean first) {
        LocalDate today = LocalDate.now();
        Month month = today.getMonth();
        Month firstMonthOfQuarter = month.firstMonthOfQuarter();
        Month endMonthOfQuarter = Month.of(firstMonthOfQuarter.getValue() + 2);
        if (first)
            return LocalDate.of(today.getYear(), firstMonthOfQuarter, 1);
        else
            return LocalDate.of(today.getYear(), endMonthOfQuarter, endMonthOfQuarter.length(today.isLeapYear()));
    }

    /**
     * 获取某日所在季度的开始日期 或 结束日期
     * 一年四季, 第一季度：1月-3月, 第二季度：4月-6月, 第三季度：7月-9月, 第四季度：10月-12月
     *
     * @param day   yyyy-MM-dd格式字符串
     * @param first true表示查询本季度开始日期  false表示查询本季度结束日期
     * @return
     */
    public static LocalDate getSomedayStartOrEndOfQuarter(String day, boolean first) {
        LocalDate date = str2LocalDate(day, DATE_FORMAT_YMD);
        Month month = date.getMonth();
        Month firstMonthOfQuarter = month.firstMonthOfQuarter();
        Month endMonthOfQuarter = Month.of(firstMonthOfQuarter.getValue() + 2);
        if (first)
            return LocalDate.of(date.getYear(), firstMonthOfQuarter, 1);
        else
            return LocalDate.of(date.getYear(), endMonthOfQuarter, endMonthOfQuarter.length(date.isLeapYear()));
    }


}
