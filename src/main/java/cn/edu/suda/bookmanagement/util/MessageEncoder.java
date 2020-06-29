package cn.edu.suda.bookmanagement.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class MessageEncoder {

    public static String encode(String encode){
        try {
            return URLEncoder.encode(encode,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}

