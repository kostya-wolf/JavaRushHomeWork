package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        IncomeData inDa;

        IncomeDataAdapter(IncomeData inDa){
            this.inDa = inDa;
        }

        @Override
        public String getCompanyName()
        {
            return inDa.getCompany();
        }

        @Override
        public String getCountryName()
        {
            return countries.get(inDa.getCountryCode());
        }

        @Override
        public String getName()
        {
            return inDa.getContactLastName().concat(", ").concat(inDa.getContactFirstName());
        }

        @Override
        public String getPhoneNumber()
        {
            StringBuilder strPhoneNum = new StringBuilder(""+inDa.getPhoneNumber());
            if (inDa.getPhoneNumber() < 1000000000) {
                for (int i=strPhoneNum.length(); i<10; i++)
                    strPhoneNum.insert(0, '0');
            }
            StringBuilder totalPhN = new StringBuilder("+");
            totalPhN.append(inDa.getCountryPhoneCode());
            totalPhN.append('(');
            totalPhN.append(strPhoneNum.subSequence(0,3));
            totalPhN.append(')');
            totalPhN.append(strPhoneNum.subSequence(3,6));
            totalPhN.append('-');
            totalPhN.append(strPhoneNum.subSequence(6,8));
            totalPhN.append('-');
            totalPhN.append(strPhoneNum.subSequence(8,10));
            return totalPhN.toString();
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}