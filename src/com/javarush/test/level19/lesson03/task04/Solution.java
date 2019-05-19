package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        PersonScannerAdapter(Scanner scanner){
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            String lastName = this.scanner.next();
            String firstName = this.scanner.next();
            String middleName = this.scanner.next();
            int date = this.scanner.nextInt();
            int month = this.scanner.nextInt();
            int year = this.scanner.nextInt();

            Date birthDate = new Date();
            try
            {
                birthDate = simpleDateFormat.parse(String.format("%d %d %d", date, month, year));
            }
            catch (ParseException e){
                e.printStackTrace();
            }

            Person p = new Person(firstName, middleName, lastName, birthDate);

            return p;
        }

        @Override
        public void close() throws IOException
        {
            this.scanner.close();
        }
    }


}
