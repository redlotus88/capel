package com.c8n.aliyun.terminnology;

/**
 * Created by dragon on 2019/11/26.
 */
public class StringBufferAndStringBuilder {

    public static void main(String[] args) {
        /**
         * 共同: StringBuffer与StringBuilder共同继承AbstractStringBuilder
         *      均可使用append方法追加字符串.
         *
         * 1. 对StringBuffer的解析:
         *    StringBuffer内部是由一组char数组来保存字符串的.
         *    初始大小 = 初始字符串长度 + 16
         *    StringBuffer是线程安全的, 共有私有方法均有Synchronized标识.
         *    序列化的对象是: ObjectStreamField 参考: https://blog.csdn.net/github_37666068/article/details/79883969
         *
         * 2. 对StringBuilder的解析:
         *    初始策略与StringBuffer一致,
         *    StringBuilder是非线程安全的, 移除了Synchronized在方法上的标识.
         *    实现序列化的方式改为writeObject, readObject. 参考: https://blog.csdn.net/mp624183768/article/details/78910258
         */

        StringBuffer sb = new StringBuffer("String Buffer"); // 初始的数组长度为13 + 16
        System.out.println(sb.toString());

        StringBuilder sb1 = new StringBuilder("String Builder");
        System.out.println(sb1.toString());
    }

}
