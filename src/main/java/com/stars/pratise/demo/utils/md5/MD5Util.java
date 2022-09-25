package com.stars.pratise.demo.utils.md5;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author stars
 * @ClassName: MD5Util
 * @Description: MD5加密解密工具类
 */

@Slf4j
public class MD5Util {

    private static final String SALT = "1357986420";

    /**
     * 16位 原加密密文
     */
    private static char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f'};


    /**
     * 使用系统指定的盐加密
     *
     * @param password
     * @return
     */
    public static String encode(String password) {
        return MD5Util.encode(SALT, password);
    }

    /**
     * 使用传入的盐加密
     *
     * @param salt
     * @param password
     * @return
     */
    public static String encode(String salt, String password) {
        password = password + salt;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }

            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 签名字符串
     *
     * @param text 需要签名的字符串
     * @param sign 对比签名结果
     * @return 签名结果
     */
    public static boolean verify(String text, String sign) {
        String mysign = encode(text);
        return mysign.equals(sign);
    }

    /**
     * 对文件进行 MD5 加密
     *
     * @param file 待加密的文件
     * @return 文件加密后的 MD5 值
     * @throws IOException
     */
    public static String md5(File file) throws IOException {
        FileInputStream is = new FileInputStream(file);
        return md5(is);

    }

    public static String md5(InputStream inputStream) throws IOException {

        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            int n = 0;
            byte[] buffer = new byte[1024];
            do {
                n = inputStream.read(buffer);
                if (n > 0) {
                    md5.update(buffer, 0, n);
                }
            } while (n != -1);
            inputStream.skip(0);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            inputStream.close();
        }

        byte[] encodedValue = md5.digest();

        int j = encodedValue.length;
        char finalValue[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte encoded = encodedValue[i];
            finalValue[k++] = Digit[encoded >> 4 & 0xf];
            finalValue[k++] = Digit[encoded & 0xf];
        }
        return new String(finalValue);
    }

}
