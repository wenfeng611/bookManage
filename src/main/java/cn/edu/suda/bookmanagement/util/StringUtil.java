package cn.edu.suda.bookmanagement.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    static {
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static int str2Int(String str, int nullVal) {
        int result = nullVal;
        try {
            if(str != null){
                result = Integer.parseInt(str);
            }
        } catch (Exception e) {

        }
        return result;
    }

    public static String getDateString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static String toJsonString(final Object jsonBean) throws Exception {
        String result = null;
        try {
            result = OBJECT_MAPPER.writeValueAsString(jsonBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
