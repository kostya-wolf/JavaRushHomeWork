package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
//            User user1 = new User();
//            user1.setFirstName("Ivan1");
//            user1.setLastName("Ivanov1");
//            user1.setMale(true);
//            user1.setCountry(User.Country.RUSSIA);
//            Calendar bd1 = Calendar.getInstance();
//            bd1.set(2006, Calendar.MAY,10);
//            user1.setBirthDate(bd1.getTime());

            User user2 = new User();
            user2.setFirstName("Petra");


//            javaRush.users.add(user1);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            for (User uss: loadedObject.users)
            {
                System.out.println(javaRush.users.get(0).getFirstName().equals(uss.getFirstName()));
                System.out.println(javaRush.users.get(0).getLastName()==uss.getLastName() || javaRush.users.get(0).getLastName().equals(uss.getLastName()));
                System.out.println(javaRush.users.get(0).getBirthDate() == uss.getBirthDate() || javaRush.users.get(0).getBirthDate().compareTo(uss.getBirthDate()) == 0);
                System.out.println(javaRush.users.get(0).isMale() == uss.isMale());
                System.out.println(javaRush.users.get(0).getCountry() == uss.getCountry());
            }


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintStream printStream = new PrintStream(outputStream);
            for (User us: users)
            {
                printStream.println(us.getFirstName());
                printStream.println(us.getLastName());
                printStream.println(us.getBirthDate() == null ? "null" : us.getBirthDate().getTime());
                printStream.println(us.isMale());
                printStream.println(us.getCountry() == null ? "null" : us.getCountry());

            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String firstName, lastName, bd, country;
            while ((firstName = reader.readLine()) != null){
                User tempUser = new User();
                tempUser.setFirstName(firstName);
                lastName = reader.readLine();
                if (!lastName.equals("null")) tempUser.setLastName(lastName);
                bd = reader.readLine();
                if (!bd.equals("null")) tempUser.setBirthDate(new Date(Long.parseLong(bd)));
                tempUser.setMale(Boolean.parseBoolean(reader.readLine()));
                country = reader.readLine();
                if (!country.equals("null")) tempUser.setCountry(User.Country.valueOf(country));
                users.add(tempUser);
            }

        }
    }
}
