package com.urise.webapp.util;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by vp on 24.05.17.
 */
public class DateUtil {

    public static LocalDate of(int year, Month month)
    {
        return LocalDate.of(year, month,1);
    }
    
}
