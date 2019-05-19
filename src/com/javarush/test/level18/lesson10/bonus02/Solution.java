package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn = reader.readLine();
        reader.close();

        if (args[0].equals("-c")){

            BufferedReader readFis = new BufferedReader(new InputStreamReader(new FileInputStream(fn), "Cp1251"));

            ArrayList<Integer> masId = new ArrayList<>();
            String s;

            while ((s = readFis.readLine()) != null){
                if (!s.isEmpty()) masId.add(Integer.parseInt(s.substring(0,8).trim()));
            }
            int maxId = 0;
            for (int ttt: masId)
            {
                if (ttt > maxId) maxId = ttt;
            }
            maxId++;
            StringBuilder strMaxId = new StringBuilder(maxId+"");
            for (int i=strMaxId.length(); i<8; i++){
                strMaxId.append(' ');
            }

            String productName = args[1];
            for (int i=2; i <= args.length-3; i++){
                productName = productName.concat(" ").concat(args[i]);
            }

            String price = args[args.length-2];
            String quantity = args[args.length-1];

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

            StringBuilder rec = strMaxId.append(strProdName).append(strPrice).append(strQuantity);

            readFis.close();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fn, true), "Cp1251"));
            if (maxId>1) writer.newLine();
            writer.write(rec.toString());
            writer.close();
        }
    }
}
