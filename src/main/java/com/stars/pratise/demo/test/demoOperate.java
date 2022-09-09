package com.stars.pratise.demo.test;

import com.stars.pratise.demo.enums.DemoEums;
import com.stars.pratise.demo.util.time.DateUtilsThree;
import com.stars.pratise.demo.util.time.LocalDateTimeUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

public class demoOperate {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ParseException {

        //“1970年1月1号0时0分0秒所差的毫秒数 时间的单位转换 1秒=1000毫秒(ms) 1分钟=60秒 1小时=60分钟=3600秒
//        System.out.println(LocalDateTime.now());
//
//        //对于泛型，只是允许程序员在编译时检测到非法的类型而已。
//        //但是在运行期时，其中的泛型标志会变化为 Object 类型。
//        //一个 List:
//        List<Integer> list = new ArrayList<>();
//
//        list.add(12);
////这里直接添加会报错
////        list.add("a");
//        Class<? extends List> clazz = list.getClass();
//        Method add = clazz.getDeclaredMethod("add", Object.class);
////但是通过反射添加，是可以的
//        add.invoke(list, "kl");
//
//        System.out.println(list);


        //将毫秒值(currentTimeMillis)转换为(年-月-日 时-分-秒)的形式,只需一行代码
//        System.out.println(new SimpleDateFormat("yy-MM-dd  HH-mm-ss").format(System.currentTimeMillis()));

//        System.out.println(DatePattern.ISO8601_FORMAT);

//        System.out.println(DateUtil.format(new Date(), DatePattern.NORM_DATETIME_FORMAT));

//        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTimeUtils.stringToLocalDateTime(DateUtilsThree.dateTime));
//        System.out.println(DateTimeUtilFour.getTodayHMS());
//        System.out.println(DateTimeUtilFour.getToday());
//        System.out.println(DateTimeUtilFour.getCurrentDateTime());
//        System.out.println(DateTimeUtilFour.getTodayBeginTime());
//        System.out.println(DateTimeUtilFour.getTodayEndTime());
        //
//        System.out.println(BusinessType.DELETE.ordinal());
//        System.out.println(BusinessType.values()[3]);
//        System.out.println(LocalDateTime.now());

//        System.out.println(Constants.DELETE.getOperateType());
//        System.out.println(Constants.DELETE.getDescribe());

        System.out.println(DemoEums.TEST.getDesc());

//        User user = new User((long) 1,"demo","2022-08-31 00:29:17");
//        ArrayList<User> errorUsers = new ArrayList<User>();
//        errorUsers.add(user);
//        System.out.println(errorUsers.get(0).toString());
    }
}
