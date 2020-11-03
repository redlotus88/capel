package com.c7n.string;

/**
 * <功能描述>
 *
 * @author jialong.wang
 * @Date on 2020/11/3 10:34 AM
 * @since 1.0
 */
public class FtpCommandStringGenerator {

    public static void main(String[] args) {
        String templateXls = "rename MD05.CMP.20201031.%s.xls ../MD05.CMP.20201031.%s.xls";
        String templateCtl = "rename MD05.CMP.20201031.%s.CTL.TMP ../MD05.CMP.20201031.%s.CTL";

        for (int i = 1; i <= 218; i++) {
            System.out.println(String.format(templateXls, i, i));
            System.out.println(String.format(templateCtl, i, i));
        }

    }
}
