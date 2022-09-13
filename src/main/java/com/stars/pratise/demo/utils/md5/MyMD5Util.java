package com.stars.pratise.demo.utils.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 加密/解密算法工具类 MD5加码 生成32位md5码
 * 做登录注册页面输入密码后，存储加密后的密码到数据库保密用的
 * @author sanch
 *
 */
public class MyMD5Util {

    /**
     * 第一种方式
     * 加盐方式
     */
    public static String md5password(String password) {

        try {
            //得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());

            StringBuffer buffer = new StringBuffer();
            //把每一个byte做一个与运算0xff;
            for(byte b:result) {
                //与运算
                int number = b & 0xff;//加盐 十六进制
                String str = Integer.toHexString(number);
                if(str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }
            //标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }

    }

    /**
     * 第二种
     * 普通方法
     * @param key
     * @return
     */
    public static String MD5(String key) {

        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 加密后解密 运行一次为加密 再运行一次为解密
     * @param inStr
     * @return
     */
    public static String JM(String inStr) {
        byte[] a = inStr.getBytes();
        for(int i = 0 ; i < a.length ; i++) {
            a[i] = (byte) (a[i] ^ 't');

        }
        return new String(a);

    }

    public static void main(String[] args) {
        System.out.println(MyMD5Util.md5password("123wert"));
        System.out.println(MyMD5Util.MD5("123"));
        System.out.println(MyMD5Util.md5password("123"));
        System.out.println(MyMD5Util.md5password(md5password(md5password("123"))));
        System.out.println(MyMD5Util.JM("123"));
        System.out.println(MyMD5Util.JM(JM("123")));
    }
}
