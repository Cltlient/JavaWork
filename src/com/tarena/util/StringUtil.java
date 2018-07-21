package com.tarena.util;

public class StringUtil {

    public static boolean isEmpty(String str){
        if(str.equals(null) || str.equals("")){
            return true;
        }else{
            return false;
        }
    }
}
