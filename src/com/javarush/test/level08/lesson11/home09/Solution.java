package com.javarush.test.level08.lesson11.home09;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
//        System.out.println("JANUARY 1 2000 = "+isDateOdd("JANUARY 1 2000"));
//        System.out.println("**************************************************************");
//
//        System.out.println("February 4 2016 = "+isDateOdd("February 4 2016"));
//        System.out.println("**************************************************************");
//
//        System.out.println("JANUARY 2 2020 = "+isDateOdd("JANUARY 2 2020"));
//        System.out.println("**************************************************************");
    }

    public static boolean isDateOdd(String date)
    {
        Date da = new Date(date);
//        System.out.println("da="+da);

        long time = da.getTime();
//        System.out.println("time of da = "+time);

        int year = da.getYear()+1900;
//        System.out.print("year of da = ");
//        System.out.println(year);

        Date day1 = new Date("JANUARY 1 "+year);
//        System.out.println("day1 = "+day1);

//        System.out.println("time-day1.getTime() ="+(time-day1.getTime()));
        long days = (time-day1.getTime())/(1000*60*60*24)+1;
//        System.out.println("идёт "+days+"-й день");
        if (days % 2 == 0) return false;
        else return true;
    }
}
