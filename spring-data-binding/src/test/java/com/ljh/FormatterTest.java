package com.ljh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.format.number.CurrencyStyleFormatter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Locale;

/**
 * Formatter
 *
 * @author ljh
 * created on 2019/10/29 9:45
 */
public class FormatterTest {

    @Test
    public void test1() throws ParseException {
        CurrencyStyleFormatter formatter = new CurrencyStyleFormatter();
        formatter.setFractionDigits(2); // 保留小数点后几位
        formatter.setRoundingMode(RoundingMode.CEILING); // 舍入模式 (ceiling 表示四舍五入)
        // 1、将带货币符号的字符串“$123.125”转换为BigDecimal("123.00")
        Assert.assertEquals(new BigDecimal("123.13"), formatter.parse("$123.125", Locale.US));
    }

    @Test
    public void test2() {
        CurrencyStyleFormatter formatter = new CurrencyStyleFormatter();
        formatter.setFractionDigits(2);
        formatter.setRoundingMode(RoundingMode.CEILING);
        // 2、将BigDecimal("123")格式化为字符串“$123.00”展示
        Assert.assertEquals("$123.00", formatter.print(new BigDecimal("123"), Locale.US));
    }
}
