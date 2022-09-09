package com.stars.pratise.demo.util.time;




public class LocalDateTimeFormatUtil{

}
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//
//
//public class LocalDateTimeFormatUtil extends BaseLocalDateFormatUtils implements
//        DatePattern {
//
//    private LocalDateTimeFormatUtil() {
//
//    }
//
//    /**
//     * 格式化成yyyy-MM-dd'T'HH:mm:ss.SSSZ
//     *
//     * @param date
//     * @return
//     */
//    public static String getFullStringWithTimeZone(Date date) {
//        return safeFormat(date, FULL_FORMAT_WITH_TIMEZONE);
//    }
//
//    /**
//     * 格式化成yyyy
//     *
//     * @param date
//     * @return
//     */
//    public static String getYearOnlyString(Date date) {
//        return safeFormat(date, YEAR_ONLY_FORMAT);
//    }
//
//    /**
//     * 格式化成yyyy-MM
//     *
//     * @param date
//     * @return
//     */
//    public static String getMonthOnlyString(Date date) {
//        return safeFormat(date, MONTH_ONLY_FORMAT);
//    }
//
//    /**
//     * 格式化成yyyy-MM-dd
//     *
//     * @param date
//     * @return
//     */
//    public static String getDateOnlyString(Date date) {
//        return safeFormat(date, DATE_ONLY_FORMAT);
//    }
//
//    /**
//     * 格式化成yyyyMMdd
//     *
//     * @param date
//     * @return
//     */
//    public static String getCompactDateOnlyString(Date date) {
//        return safeFormat(date, COMPACT_DATE_ONLY_FORMAT);
//    }
//
//    /**
//     * 格式化成yyyy-MM-dd HH:mm
//     *
//     * @param date
//     * @return
//     */
//    public static String getMinutesOnlyString(Date date) {
//        return safeFormat(date, MINUTES_ONLY_FORMAT);
//    }
//
//    /**
//     * 格式化成yyyy-MM-dd HH:mm:ss
//     *
//     * @param date
//     * @return
//     */
//    public static String getFullString(Date date) {
//        return safeFormat(date, FULL_FORMAT);
//    }
//
//    /**
//     * 格式化成yyyy-MM-dd 00:00:00
//     *
//     * @param date
//     * @return
//     */
//    public static String getDateStartString(Date date) {
//        return safeFormat(date, DATE_START_FORMAT);
//    }
//
//    /**
//     * 格式化成yyyy-MM-dd 23:39:59
//     *
//     * @param date
//     * @return
//     */
//    public static String getDateEndString(Date date) {
//        return safeFormat(date, DATE_END_FORMAT);
//    }
//
//    /**
//     * 格式化成yyyyMMddHHmmss
//     *
//     * @param date
//     * @return
//     */
//    public static String getCompactionFullString(Date date) {
//        return safeFormat(date, DATE_COMPACTION_FULL_FORMAT);
//    }
//
//    /**
//     * 格式化成yyyy年MM月dd日
//     *
//     * @param date
//     * @return
//     */
//    public static String getChineseDateOnlyString(Date date) {
//        return safeFormat(date, CHINESE_DATE_ONLY_FORMAT);
//    }
//
//    /**
//     * 格式化成yyyy年MM月dd日 HH时mm分ss秒
//     *
//     * @param date
//     * @return
//     */
//    public static String getChineseFullString(Date date) {
//        return safeFormat(date, CHINESE_FULL_FORMAT);
//    }
//
//    /**
//     * 格式化成yyyy年MM月
//     *
//     * @param date
//     * @return
//     */
//    public static String getChineseMonthOnlyString(Date date) {
//        return safeFormat(date, CHINESE_MONTH_ONLY_FORMAT);
//    }
//
//    /**
//     * 格式化成yyyyMM
//     *
//     * @param date
//     * @return
//     */
//    public static String getYearMonthOnlyString(Date date) {
//        return safeFormat(date, COMPACT_MONTH_ONLY);
//    }
//
//    /**
//     * 格式化
//     *
//     * @param date    日期
//     * @param pattern 格式
//     * @return
//     */
//    private static String safeFormat(Date date, String pattern) {
//        if (date == null || pattern == null) {
//            return null;
//        }
//        LocalDateTime localDateTime = dateToLocalDateTime(date);
//        if (null != localDateTime) {
//            return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
//        }
//        return null;
//    }
//
//    /**
//     * 格式化成HH:mm:ss
//     *
//     * @param date 日期
//     * @return
//     */
//    public static String timeFormat(Date date) {
//        return safeFormat(date, TIME_ONLY_FORMAT);
//    }
//
//    public static void main(String args[]) {
//        System.out.println(getChineseFullString(new Date()));
//    }
//}
