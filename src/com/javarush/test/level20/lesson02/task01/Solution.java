package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
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

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            Human petrov = new Human("Petrov");

            ivanov.save(outputStream);
            outputStream.flush();

//            petrov.save(outputStream);
//            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
//            if (ivanov.hashCode() == somePerson.hashCode()) System.out.println("ivanov.hashCode() == somePerson.hashCode()");
//            else System.out.println("ivanov.hashCode() != somePerson.hashCode()");
            System.out.println(ivanov.name + "___" + somePerson.name + "___" + ivanov.name.equals(somePerson.name));
            System.out.println(ivanov.assets.get(0).getName() + "___" + somePerson.assets.get(0).getName() + "___" + ivanov.assets.get(0).getName().equals(somePerson.assets.get(0).getName()));
            System.out.println(ivanov.assets.get(0).getPrice() + "___" + somePerson.assets.get(0).getPrice() + "___" + Double.compare(ivanov.assets.get(0).getPrice(), somePerson.assets.get(0).getPrice()));


//            Human maybePetrov = new Human();
//            maybePetrov.load(inputStream);
//            if (petrov.hashCode() == maybePetrov.hashCode()) System.out.println("petrov.hashCode() == maybePetrov.hashCode()");
//            else System.out.println("petrov.hashCode() != maybePetrov.hashCode()");

//            System.out.println(petrov.name + "___" + maybePetrov.name + "___" + petrov.name.equals(maybePetrov.name));

            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println(this.name);
            printStream.println(this.assets.size());
            for (Asset oneAsset: assets)
            {
                printStream.println(oneAsset.getName());
                printStream.println(oneAsset.getPrice());
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            this.name = reader.readLine();
            int sizeOfAssets = Integer.parseInt(reader.readLine());
            for (int i=0; i<sizeOfAssets; i++){
                String assetName = reader.readLine();
                double assetPrice = Double.parseDouble(reader.readLine());
                Asset tempAsset = new Asset(assetName);
                tempAsset.setPrice(assetPrice);
                this.assets.add(tempAsset);
            }
        }
    }
}
