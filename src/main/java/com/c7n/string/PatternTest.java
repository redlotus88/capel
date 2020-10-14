package com.c7n.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <功能描述>
 *
 * @author jialong.wang
 * @Date on 2020/8/16 8:31 PM
 * @since 1.0
 */
public class PatternTest {

    public static void main(String[] args) {
//        String sqlTest = "select * from table_1 a left join table_2 b on a.id = b.id left join table_3 c on a.id = c.id where a.id = 123";
//        Pattern p = Pattern.compile("\\s+join\\s+(\\w+)\\s+(\\w+)\\s+on");
//        Matcher m = p.matcher(sqlTest);
//
//        int matcherStarter = 0;
//        while (m.find(matcherStarter)) {
//            System.out.println(m.group(1) + " :  " + m.group(2));
//            matcherStarter = m.end();
//        }

        String sqlTest = "select * from table_1 where id = 1";
        Pattern fromTablePattern = Pattern.compile("\\s+from\\s+(\\w+)\\s+(\\w+)\\s+(where|left|join|inner)");

        final Matcher matcher = fromTablePattern.matcher(sqlTest);
        if (matcher.find()) {
            System.out.println(matcher.group(1) + " : " + matcher.group(2));
        }
    }
}
