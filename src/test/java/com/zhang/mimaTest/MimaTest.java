package com.zhang.mimaTest;

import com.zhang.ssmschoolshop.util.Md5Util;

public class MimaTest {
    public static void main(String[] args) {
        String str = "12345678";

        String s = Md5Util.MD5Encode(str, "UTF-8");

        System.out.println(s);
    }
}
