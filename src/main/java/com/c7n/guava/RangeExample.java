package com.c7n.guava;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * <功能描述>
 *
 * @author jialong.wang
 * @Date on 2020/8/19 10:28 AM
 * @since 1.0
 */
public class RangeExample {

    public static void main(String[] args) throws Exception {
        String time= "2018-08-01T23:01:21.905+0800";

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //字符串转换为util.Date，timestamp-->Wed Aug 01 10:01:21 CST 2018
        java.util.Date date = format1.parse(time);

        //timestamp-->2018-08-01 10:01:21
        String timestamp = format2.format(format1.parse(time));

        //sqlStamp-->2018-08-01 10:01:21.0(为什么会有毫秒?因为Timestamp就是精确到毫秒的)
        Timestamp sqlStamp = new Timestamp(format2.parse(timestamp).getTime());

        //util.Date转sql.Date-->2018-08-01
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());

        System.out.println("sqlDate=========================" + sqlDate);
    }
}
