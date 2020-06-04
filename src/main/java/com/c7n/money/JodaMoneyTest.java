package com.c7n.money;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class JodaMoneyTest {

    public static void main(String[] args) {
        // 单一币种测试： 美元
        Money money = Money.parse("USD 23.87");
        System.out.println("货币显示：" + money);
        System.out.println("当前货币币种： " + money.getCurrencyUnit());

        // add another amount with safe double conversion
        CurrencyUnit usd = CurrencyUnit.of("USD");
        money = money.plus(Money.of(usd, 12.43d));
        System.out.println("增加12.43美元： " + money);

        // subtracts an amount in dollars
        money = money.minusMajor(2);
        System.out.println("减2美元： " + money);

        // multiplies by 3.5 with rounding
        money = money.multipliedBy(3.5d, RoundingMode.DOWN);
        System.out.println("乘以3.5倍： " + money);

        // compare two amounts
        boolean bigAmount = money.isGreaterThan(() -> BigMoney.of(CurrencyUnit.USD, 100));
        System.out.println("是否比100美元大: " +  bigAmount);

        // convert to JPY using a supplied rate
        BigDecimal conversionRate = new BigDecimal(108);  // obtained from code outside Joda-Money
        Money moneyJPY = money.convertedTo(CurrencyUnit.JPY, conversionRate, RoundingMode.HALF_UP);
        System.out.println("120.05美元转换成日元：" + moneyJPY);

        // use a BigMoney for more complex calculations where scale matters
        BigMoney moneyCalc = money.toBigMoney();
        System.out.println("转换成BigMoney: " + moneyCalc);
    }
}
