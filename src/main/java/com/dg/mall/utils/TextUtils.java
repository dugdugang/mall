package com.dg.mall.utils;

public class TextUtils {

    public static boolean isEmpty(String str) {
        if (str != null || !str.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean notEmpty(String str) {
        if (str != null && !str.equals("")) {
            return true;
        } else {
            return false;
        }
    }
}
