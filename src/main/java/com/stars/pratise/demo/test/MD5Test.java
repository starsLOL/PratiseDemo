package com.stars.pratise.demo.test;

import com.stars.pratise.demo.utils.md5.MD5UtilThree;

import java.io.File;
import java.io.IOException;

public class MD5Test {
    public static void main(String[] args) throws IOException {
        long begin = System.currentTimeMillis();

        File file = new File("/Users/mac/Desktop/demo.txt");
        if (!file.exists()) {
            System.out.println("不存在");
        }
        String md5 = MD5UtilThree.md5(file);

//      String md5 = getMD5String("a");

        long end = System.currentTimeMillis();
        System.out.println("md5:" + md5 + " time:" + ((end - begin) / 1000) + "s");
        System.out.println(file.getPath());
    }
}
