package com.stars.pratise.demo.utils.md5;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description: MD5 加密工具类
 * @Author: 云诺
 * @Date: 2020/12/31 11:57
 */
@Slf4j
public class MD5Utils {


    /**
     * 16位 原加密密文
     */
    protected static char[] HEXDIGITS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    /**
     * 摘要密文
     */
    protected static MessageDigest MESSAGEDIGEST = null;

    static {

        try {

            // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
            MESSAGEDIGEST = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {

            log.error(MD5Utils.class.getName() + "初始化失败，MessageDigest不支持MD5Util.");
        }
    }

    private static String bufferToHex(byte[] bytes) {

        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte[] bytes, int m, int n) {

        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {

            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {

        char c0 = HEXDIGITS[(bt & 0xf0) >> 4];
        char c1 = HEXDIGITS[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }


    /**
     * 字符串的md5加密
     *
     * @param input 需要加密的字符串
     * @return 字符串加密MD5密钥
     */
    public static String string2MD5(String input) {

        try {

            // 输入的字符串转换成字节数组
            byte[] inputByteArray = input.getBytes();
            MESSAGEDIGEST.update(inputByteArray);
            // 转换并返回结果
            byte[] resultByteArray = MESSAGEDIGEST.digest();
            // 字符数组转换成字符串
            return bufferToHex(resultByteArray);
        } catch (Exception e) {

            //字符串加密失败
            log.error("字符串MD5加密失败" + e + e.getMessage());
            return "";
        }

    }

    /**
     * 文件的md5加密
     *
     * @param inputFile 需要加密的文件
     * @return 文件加密MD5密钥
     * @throws IOException
     */
    public static String file2MD5(File inputFile) throws IOException {

        // 缓冲区大小
        int bufferSize = 256 * 1024;
        // 文件流
        FileInputStream fileInputStream = null;
        // 摘要流
        DigestInputStream digestInputStream = null;
        try {

            // 使用DigestInputStream
            fileInputStream = new FileInputStream(inputFile);
            digestInputStream = new DigestInputStream(fileInputStream, MESSAGEDIGEST);
            // read的过程中进行MD5处理，直到读完文件
            byte[] buffer = new byte[bufferSize];
            while (digestInputStream.read(buffer) > 0) {

                ;
            }
            // 获取最终的MessageDigest
            MESSAGEDIGEST = digestInputStream.getMessageDigest();
            // 拿到结果，也是字节数组，包含16个元素
            byte[] resultByteArray = MESSAGEDIGEST.digest();
            // 把字节数组转换成字符串
            return bufferToHex(resultByteArray);
        } catch (Exception e) {

            log.error("文件的md5加密失败" + e + e.getMessage());
            return "";
        } finally {

            try {

                digestInputStream.close();
            } catch (Exception e) {

                log.error("文件的md5加密-关闭流失败" + e + e.getMessage());
            }
        }

    }
}

