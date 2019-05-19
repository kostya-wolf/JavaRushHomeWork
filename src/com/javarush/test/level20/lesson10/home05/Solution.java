package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString = "Hello, ";
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException
        {
            in.defaultReadObject();
            this.fullName = String.format("%s, %s", lastName, firstName);
        }
    }

    enum Sex implements Serializable {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Person person = new Person("Name", "FamilyName", "Russia", Sex.MALE);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("cat.dat"));
        objectOutputStream.writeObject(person);
        objectOutputStream.close();

        System.out.println(person.firstName);
        System.out.println(person.lastName);
        System.out.println(person.fullName);
        System.out.println(person.country);
        System.out.println(person.greetingString);
        System.out.println(person.logger);
        System.out.println(person.outputStream);
        System.out.println(person.sex);

        System.out.println("******************************");

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("cat.dat"));
        Person p2 = (Person) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(p2.firstName);
        System.out.println(p2.lastName);
        System.out.println(p2.fullName);
        System.out.println(p2.country);
        System.out.println(p2.greetingString);
        System.out.println(p2.logger);
        System.out.println(p2.outputStream);
        System.out.println(p2.sex);
    }
}
