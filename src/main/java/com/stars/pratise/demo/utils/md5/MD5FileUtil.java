package com.stars.pratise.demo.utils.md5;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.security.MessageDigest;


public class MD5FileUtil {

    static char hexdigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};


    /**
     * @param file:要加密的文件
     * @return MD5摘要码
     * @funcion 对文件全文生成MD5摘要
     */

    public static String getMD5(File file) {

        FileInputStream fis = null;

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            fis = new FileInputStream(file);

            byte[] buffer = new byte[2048];

            int length = -1;

            while ((length = fis.read(buffer)) != -1) {

                md.update(buffer, 0, length);

            }

            byte[] b = md.digest();

            return byteToHexString(b);

        } catch (Exception e) {

            e.printStackTrace();

            return null;

        } finally {

            try {

                fis.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }


    /**
     * @param tmp 要转换的byte[]
     * @return 十六进制字符串表示形式
     * @function 把byte[]数组转换成十六进制字符串表示形式
     */

    private static String byteToHexString(byte[] tmp) {

        String s;

        // 用字节表示就是 16 个字节

        // 每个字节用 16 进制表示的话，使用两个字符，所以表示成 16 进制需要 32 个字符

        // 比如一个字节为01011011，用十六进制字符来表示就是“5b”

        char str[] = new char[16 * 2];

        int k = 0; // 表示转换结果中对应的字符位置

        for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节转换成 16 进制字符的转换

            byte byte0 = tmp[i]; // 取第 i 个字节

            str[k++] = hexdigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移

            str[k++] = hexdigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换

        }


        s = new String(str); // 换后的结果转换为字符串

        return s;

    }


//    public static void main(String arg[]) {
//
//        String a = getMD5(new File("e:/a.txt"));
//
//        String b = getMD5(new File("e:/b.txt"));
//
//        String c = getMD5(new File("e:/c.txt"));
//
//
//        System.out.println("a.txt的摘要值为：" + a);
//
//        System.out.println("b.txt的摘要值为：" + b);
//
//        System.out.println("c.txt的摘要值为：" + c);
//
//
//        if (a.equals(b)) {
//
//            System.out.println("a.txt中的内容与b.txt中的内容一致");
//
//        } else {
//
//            System.out.println("a.txt中的内容与b.txt中的内容不一致");
//
//        }
//
//
//        if (a.equals(c)) {
//
//            System.out.println("a.txt中的内容与c.txt中的内容一致");
//
//        } else {
//
//            System.out.println("a.txt中的内容与c.txt中的内容不一致");
//
//        }
//
//    }

//    运行之前建立文件：
//
//    在E盘根目录下建立a.txt、b.txt和c.txt。
//
//    a.txt中的内容为“123456”。
//
//    b.txt中的内容为“123456”。
//
//    c.txt中的内容为“654321”。
//
//    运行结果：
//
//    a.txt的摘要值为：c4ca4238a0b923820dcc509a6f75849b
//
//    b.txt的摘要值为：e10adc3949ba59abbe56e057f20f883e
//
//    c.txt的摘要值为：c33367701511b4f6020ec61ded352059
//
//    a.txt中的内容与b.txt中的内容不一致
//
//    a.txt中的内容与c.txt中的内容不一致
//
//    结论：
//
//    从代码本身和运行结果都可以看出，MD5对文件的加密是加密文件中的内容，不管文件名是什么，相同的文件内容经过MD5算法处理后得到的摘要值也相同

}
