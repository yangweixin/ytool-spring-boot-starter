package top.oyoung.ext.tool.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String DATE_FORMAT_SHORT = "YYYY-MM-DD mm:dd:ss";
    public static String  getToday(String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_SHORT);
        return dateFormat.format(new Date());
    }
}
