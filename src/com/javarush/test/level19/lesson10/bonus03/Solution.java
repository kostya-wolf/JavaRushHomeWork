package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();

        String tag = args[0];

        StringBuilder sb = new StringBuilder();
        String s;

        while ((s = reader.readLine()) != null){
            if (s.length() > 0 && (s.charAt(0) == '<' || s.charAt(0) == ' ' || sb.charAt(sb.length()-1) == '>' || sb.charAt(sb.length()-1) == ' ')) sb.append(s);
            else sb.append(' ').append(s);
        }

        String regex1 = "<"+tag+" [^>]*?>|<"+tag+">";
        String regex3 = "</"+tag+">";

        Pattern p = Pattern.compile(""+regex1+"");
        Pattern p3 = Pattern.compile(""+regex3+"");

        Matcher m = p.matcher(sb);
        Matcher m3, temp;


        while (sb.length()>0){
            m = m.reset(sb);
            if (m.find()) {
                sb = sb.delete(0, m.start());
                m3 = p3.matcher(sb);
                if (m3.find()){
                    int indexEnd = m3.end();
                    temp = p.matcher(sb.subSequence(0,m3.start()));
                    int count = 0;
                    while (temp.find()){
                        count++;
                    }
                    if (count>1)
                    {
                        int cc = count;
                        temp = p3.matcher(sb.subSequence(m3.end(), sb.length()));
                        while (cc > 1)
                        {
                            temp.find();
                            cc--;
                        }
                        indexEnd += temp.end();
                    }
                    poisk(sb.substring(0,indexEnd), count, regex1, regex3);
                    sb = sb.delete(0,indexEnd);
                }
                else sb.setLength(0);
            }
            else sb.setLength(0);
        }

        System.out.println(sb);
        reader.close();
    }

    private static void poisk(String s, int count, String regex1, String regex3)
    {
        Pattern p1 = Pattern.compile(regex1);
        Pattern p2 = Pattern.compile(regex3);
        Matcher m1,m2;
        m1 = p1.matcher(s);
        m2 = p2.matcher(s);

        for (int i=0; i<count; i++){

            m1 = m1.reset();

            for (int j=count-i-1; j<count; j++){
                m1.find();
            }


            m2 = m2.reset();
            for (int j=i; j<count; j++){
                m2.find();
            }

            String str = s.substring(m1.start(),m2.end());

            System.out.println(str);


        }

    }

}