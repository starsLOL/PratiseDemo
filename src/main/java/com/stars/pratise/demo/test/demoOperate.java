package com.stars.pratise.demo.test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.stars.pratise.demo.domain.Book;
import com.stars.pratise.demo.utils.md5.MD5Util;
import com.stars.pratise.demo.common.TypeConversion;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demoOperate {
    private static Object Book;

//    public static int i;
//    public static Integer j;

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ParseException {


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 4);
        map.put("author", "demo");
        map.put("name", "test");
        map.put("price", 23.2);

        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(map);
        Book pojo = gson.fromJson(jsonElement, Book.class);

        System.out.println(pojo.toString());



//        TypeConversion.convert(map, Book);
//        System.out.println(MD5Util.encode("123456"));

        /**
         * 返回分页成功数据
         */
//        public CommonResult pageSuccess(List data) {
//            PageInfo pageInfo = new PageInfo(data);
//            Map<String, Object> result = new HashMap<>();
//            result.put("pageSize", pageInfo.getPageSize());
//            result.put("totalPage", pageInfo.getPages());
//            result.put("total", pageInfo.getTotal());
//            result.put("pageNum", pageInfo.getPageNum());
//            result.put("list", pageInfo.getList());
//            this.code = SUCCESS;
//            this.message = "操作成功";
//            this.data = result;
//            return this;
//        }


        /**
         * copy原有的分页信息，除数据
         *
         * @param ordinal
         * @param <T>
         * @return
         */
//        private <T> PageInfo<T> copyPageInfo(PageInfo ordinal) {
//            PageInfo<T> returnBo = new PageInfo<T>();
//            returnBo.setPageSize(ordinal.getPageSize());
//            returnBo.setPageNum(ordinal.getPageNum());
//            returnBo.setEndRow(ordinal.getEndRow());
//            returnBo.setTotal(ordinal.getTotal());
//            returnBo.setHasNextPage(ordinal.isHasNextPage());
//            returnBo.setHasPreviousPage(ordinal.isHasPreviousPage());
//            returnBo.setIsFirstPage(ordinal.isIsFirstPage());
//            returnBo.setIsLastPage(ordinal.isIsLastPage());
//            returnBo.setNavigateFirstPage(ordinal.getNavigateFirstPage());
//            returnBo.setNavigateLastPage(ordinal.getNavigateLastPage());
//            returnBo.setNavigatepageNums(ordinal.getNavigatepageNums());
//            returnBo.setSize(ordinal.getSize());
//            returnBo.setPrePage(ordinal.getPrePage());
//            returnBo.setNextPage(ordinal.getNextPage());
//            return returnBo;
//        }


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
////但是通过反射添加，是可以的keySet()
//        add.invoke(list, "kl");
//
//        System.out.println(list);


        //将毫秒值(currentTimeMillis)转换为(年-月-日 时-分-秒)的形式,只需一行代码
//        System.out.println(new SimpleDateFormat("yy-MM-dd  HH-mm-ss").format(System.currentTimeMillis()));

//        System.out.println(DatePattern.ISO8601_FORMAT);

//        System.out.println(DateUtil.format(new Date(), DatePattern.NORM_DATETIME_FORMAT));

//        System.out.println(LocalDateTime.now());
//        System.out.println(LocalDateTimeUtils.stringToLocalDateTime(DateUtilsThree.dateTime));
//
////        Java为每个原始类型提供了封装类，Integer是java为int提供的封装类。
////        int的默认值为0，而Integer的默认值为null，即Integer可以区分出未赋值和值为0的区别，int则无法表达出未赋值的情况。
//        Integer integer = Integer.valueOf("100");
//        System.out.println(integer);

//        Java静态变量初始化遵循以下规则:
//        1.静态变量会按照声明的顺序先依次声明并设置为该类型的默认值，但不赋值为初始化的值。
//        2.声明完毕后,再按声明的顺序依次设置为初始化的值，如果没有初始化的值就跳

//        int i;
//        Integer j;
//        System.out.println(i);
//        System.out.println(j);

//        String str = " 1, 2, 3,   4 ";
////        System.out.println(str.replaceAll("\\s+", ""));
//        for (String s : str.replaceAll("\\s+", "").split(",")) {
//            System.out.println(s);
//        }


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

//        System.out.println(DemoEums.TEST.getDesc());
//
//        System.out.println("hello world");
//
//        System.out.println(new Date());

//        User user = new User((long) 1,"demo","2022-08-31 00:29:17");
//        ArrayList<User> errorUsers = new ArrayList<User>();
//        errorUsers.add(user);
//        System.out.println(errorUsers.get(0).toString());
    }
}
