package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new T1());
        threads.add(new T2());
        threads.add(new T3());
        threads.add(new T4());
        threads.add(new T5());
    }

    public static void main(String[] args) throws Exception
    {
        for (int i = 0; i < threads.size(); i++)
        {
            threads.get(i).start();
        }

        T4 t4 = (T4) threads.get(3);

        sleep(2000);

        threads.get(1).interrupt();

        if (t4.isAlive()) t4.showWarning();


        sleep(5000);

        for (int i = 0; i < threads.size(); i++)
        {
            System.out.println("threads.get("+i+").isAlive()= " +threads.get(i).isAlive());
        }
    }
}

class T1 extends Thread{
    @Override
    public void run()
    {
        while (true){

        }
    }
}

class T2 extends Thread{
    @Override
    public void run()
    {
        while (true){
            try {
                sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("InterruptedException");
                return;
            }
        }
    }
}

class T3 extends Thread{
    @Override
    public void run()
    {
        while (true){
            System.out.println("Ура");
            try{
                sleep(500);
            }
            catch (InterruptedException e){
                return;
            }
        }
    }
}

class T4 extends Thread implements Message {
    private boolean working=true;

    public void showWarning(){
        try{
            working = false;
            join();
        }
        catch (InterruptedException e){}
    }

    @Override
    public void run()
    {
        while (working){
            try{
                sleep(1);
            }
            catch (InterruptedException e){
                System.out.println("T4 InterruptedException");
                return;
            }
        }
    }
}

class T5 extends Thread{
    @Override
    public void run()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s="";
        int sum=0;
        try{
            while (!(s = reader.readLine()).equals("N")) {
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
            reader.close();
        }
        catch (IOException e){
            System.out.println(e);
            return;
        }
    }
}
