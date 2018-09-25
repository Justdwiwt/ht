package cn.tedu.ht.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("unused")
public class TimeTool {

    /**
     * 获取当前时间
     *
     * @param date Date
     * @return format(date)
     */
    public static String getTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

}
