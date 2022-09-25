package com.stars.pratise.demo.test;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stars.pratise.demo.crud.BaseServices;
import com.stars.pratise.demo.domain.Money;
import com.sun.tools.javac.comp.Todo;
import net.sf.json.JsonConfig;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ConvertDemo {

//    public static <T> List<T> castList(Object obj, Class<T> clazz) {
//        List<T> result = new ArrayList<T>();
//        if (obj instanceof List<?>) {
//            for (Object o : (List<?>) obj) {
//                result.add(clazz.cast(o));
//            }
//            return result;
//        }
//        return null;
//    }
//
//    public static Object getObj() {
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("ab");
//        return list;
//    }

//    public static List<String> objToList(Object obj) {
//        List<String> result = new ArrayList<String>();
//        if (obj instanceof ArrayList<?>) {
//            for (Object o : (List<?>) obj) {
//                result.add(String.class.cast(o));
//            }
//        }
//        return result;
//    }

//    public static Map initQueryMap(String code, String symbol, String data) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("CODE", code);
//        map.put("SYMBOL", symbol);
//        map.put("DATA", data);
//        return map;
//    }
//
//    @org.junit.jupiter.api.Test
//    public void mapToJson(){
//        List<Map> extList = new ArrayList<>();
//        extList.add(initQueryMap("BILL_TYPE_CODE","1", "12"));
//        System.out.println(JSON.toJSONString(extList));
//        System.out.println(extList);
//    }
    //结果：
// [{"CODE":"BILL_TYPE_CODE","SYMBOL":"1","DATA":"12"}]
// [{CODE=BILL_TYPE_CODE, SYMBOL=1, DATA=12}]

    public static void main(String[] args) {

        String code = "Money{id=12, name='赵俊', money=22.11}";
        System.out.println("before: " + code);
        if (code.contains("{")) {
            int index = code.indexOf("{");
            code = code.substring(index, code.length());
        }
        code.replaceAll("\\s+", "");
        System.out.println("after: " + code.replaceAll("\\s+", "").replace("=", ":"));
        System.out.println("after: " + code);


//        Object obj = "Money{id:12, name:'stars', money:22.11}";
        Object obj = "{id:12, name:'stars', money:22.11}";

//        Object str1 = "Money{id=12, name='asdxzc', money=22.11, isDeleted=null, createAt=null, updateAt=null}";
//
        Gson gson = new Gson();
//
//        String jsonString = gson.toJson(obj);
//
//        System.out.println("json字符串:"+jsonString);
        //解析json字符串

//        List<Map<String,Object>> list2 = gson.fromJson(obj.toString(), new TypeToken<List<Map<String,Object>>>(){}.getType());
        Map<String, Object> list2 = gson.fromJson(obj.toString(), new TypeToken<Map<String, Object>>() {
        }.getType());

        System.out.println(list2.get("id"));



//        List listObjectFour = JSONArray.parseArray(obj.toString(), Map.class);
//        System.out.println("利用JSONArray中的parseArray方法并指定返回类型来解析json数组字符串");
//        System.out.println(listObjectFour);
//        for(Object mapList : listObjectFour){
//            for (Object entry : ((Map)mapList).entrySet()){
//                System.out.println(((Map.Entry)entry).getKey()  + "  " +((Map.Entry)entry).getValue());
//            }
//        }//结果：//利用JSONArray中的parseArray方法并指定返回类型来解析json数组字符串


//        System.out.println(obj.toString());
//        JSONArray jsonArray = JSONArray.fromObject(obj);
//
//        List<Money> todos = JSONArray.toList(jsonArray, new Money() , new JsonConfig());

//        System.out.println(todos.get(0));

//        List<T> list = new ArrayList<T>();
//        JSONArray jsonArray = JSONArray.fromObject(str);//把String转换为json
//        list = JSONArray.toList(jsonArray,t);//这里的t是Class<T>

//        JSONArray json = JSONArray.fromObject(obj);
//        String str = json.toString();//把json转换为String
//
//        System.out.println(str);


//        Gson gson = new Gson();

//        List<String> yearArr = Collections.singletonList(gson.to(str, List.class));

//        System.out.println(yearArr.toString());

//        System.out.println(JSON.toJSON(str));
//        Object obj = getObj();
//        List<String> list = castList(obj, String.class);
//        list.forEach(System.out::println);

//        Object obj = getObj();
//        List<String> result = new ArrayList<>();
//        if (obj instanceof ArrayList<?>) {
//            for (Object o : (List<?>) obj) {
//                result.add(String.class.cast(o));
//            }
//        }
//        result.forEach(System.out::println); // 输出：1 ab
    }
}
