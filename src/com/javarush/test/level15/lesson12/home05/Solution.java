package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    Solution(){}
    Solution(Double d){
        System.out.println("Double");
    }
    Solution(Double d, Double d2){
        System.out.println("Double-Double");
    }

    public Solution(int a){
        System.out.println("int a");
    }
    public Solution(int a, int b){
        System.out.println("int a - int b");
    }
    public Solution(int a, int b, int c){
        System.out.println("int a - int b - int c");
    }

    private Solution(String s){
        System.out.println(s);
    }
    private Solution(String s, String s2){
        System.out.println(s+" "+s2);
    }
    private Solution(String s, String s2, String s3){
        System.out.println(s+" "+s2+" "+s3);
    }


    protected Solution(boolean s){
        System.out.println(s);
    }
    protected Solution(boolean s, boolean s2){
        System.out.println(s+" "+s2);
    }
    protected Solution(boolean s, boolean s2, boolean s3){
        System.out.println(s+" "+s2+" "+s3);
    }
}

