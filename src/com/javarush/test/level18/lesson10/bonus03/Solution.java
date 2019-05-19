package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn = reader.readLine();
        reader.close();

        if (args[0].equals("-u")){
            BufferedReader readFis = new BufferedReader(new InputStreamReader(new FileInputStream(fn), "Cp1251"));

            ArrayList<String> allFile = new ArrayList<>();
            ArrayList<Integer> masId = new ArrayList<>();
            String s;

            while ((s = readFis.readLine()) != null){
                allFile.add(s);
                if (!s.isEmpty()) masId.add(Integer.parseInt(s.substring(0,8).trim()));
                else masId.add(null);
            }

            int id = Integer.parseInt(args[1]);

            String productName = args[2];
            for (int i=3; i <= args.length-3; i++){
                productName = productName.concat(" ").concat(args[i]);
            }

            String price = args[args.length-2];
            String quantity = args[args.length-1];

            if (masId.contains(id)){

                StringBuilder strId = new StringBuilder(id+"");
                for (int i=strId.length(); i<8; i++){
                    strId.append(' ');
                }

                StringBuilder strProdName = new StringBuilder(productName);
                for (int i=strProdName.length(); i<30; i++){
                    strProdName.append(' ');
                }
                strProdName.setLength(30);

                StringBuilder strPrice = new StringBuilder(price);
                for (int i=strPrice.length(); i<8; i++){
                    strPrice.append(' ');
                }
                strPrice.setLength(8);

                StringBuilder strQuantity = new StringBuilder(quantity);
                for (int i=strQuantity.length(); i<4; i++){
                    strQuantity.append(' ');
                }
                strQuantity.setLength(4);

                StringBuilder rec = strId.append(strProdName).append(strPrice).append(strQuantity);

                int indexStr = masId.indexOf(id);
                allFile.set(indexStr, rec.toString());
            }
            readFis.close();

            if (masId.contains(id)){
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fn), "Cp1251"));
                for (int i=0; i<allFile.size(); i++){
                    writer.write(allFile.get(i));
                    writer.newLine();
                }
                writer.close();
            }
        }

        if (args[0].equals("-d")){
            BufferedReader readFis = new BufferedReader(new InputStreamReader(new FileInputStream(fn), "Cp1251"));

            ArrayList<String> allFile = new ArrayList<>();
            ArrayList<Integer> masId = new ArrayList<>();
            String s;

            while ((s = readFis.readLine()) != null){
                allFile.add(s);
                if (!s.isEmpty()) masId.add(Integer.parseInt(s.substring(0,8).trim()));
                else masId.add(null);
            }

            int id = Integer.parseInt(args[1]);
            if (masId.contains(id)){
                int indexStr = masId.indexOf(id);
                allFile.remove(indexStr);
            }
            readFis.close();

            if (masId.contains(id)){
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fn), "Cp1251"));
                for (int i=0; i<allFile.size(); i++){
                    writer.write(allFile.get(i));
                    writer.newLine();
                }
                writer.close();
            }
        }
    }
}
