package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String key = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];

        FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutputName);

        if (key.equals("-e")){
            for (int i=49; i<53; i++){
                fos.write(i);
            }
            while (fis.available() > 0){
                int sym = fis.read();
                if (sym>=0 && sym<=127){
                    sym += 128;
                }
                else if (sym>=128 && sym<=255){
                    sym -= 128;
                }
                fos.write(sym);
            }
        }
        else if (key.equals("-d")){
            for (int i=0; i<4; i++){
                fis.read();
            }
            while (fis.available() > 0){
                int sym = fis.read();
                if (sym>=0 && sym<=127){
                    sym += 128;
                }
                else if (sym>=128 && sym<=255){
                    sym -= 128;
                }
                fos.write(sym);
            }
        }

        fis.close();
        fos.close();
    }

}
