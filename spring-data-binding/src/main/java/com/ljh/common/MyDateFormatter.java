package com.ljh.common;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Formatter
 * 全局/局部使用，Source(String)
 *
 * @author ljh
 * created on 2019/10/29 10:16
 */
public class MyDateFormatter implements Formatter<Date> {
    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        return null;
    }
}
