package com.c7n.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <功能描述>
 *
 * @author jialong.wang
 * @Date on 2020/11/23 10:55 AM
 * @since 1.0
 */
public class DateConverterJson {


    public static void main(String[] args) {
        TestObject to = new TestObject("2020-11-12","2020-12-31","1","2");

//        JSON.toJSON(to);
        final TestObject testObject = JSONObject.toJavaObject(JSON.parseObject(JSON.toJSONString(to)), TestObject.class);
        System.out.println(testObject);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class TestObject {
        String date1;
        String date2;
        String test1;
        String test2;

        public String getDate1() {
            return date1.replaceAll("-", "/");
        }

        public void setDate1(String date1) {
            this.date1 = date1;
        }
    }
}


