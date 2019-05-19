package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Волковы on 11.08.2016.
 */
public class SubSolution extends Solution
{
    SubSolution()
    {
    }

    SubSolution(Double d)
    {
        super(d);
    }

    SubSolution(Double d, Double d2)
    {
        super(d, d2);
    }

    public SubSolution(int a)
    {
        super(a);
    }

    public SubSolution(int a, int b)
    {
        super(a, b);
    }

    public SubSolution(int a, int b, int c)
    {
        super(a, b, c);
    }

    private SubSolution(String s){
        System.out.println(s);
    }
    private SubSolution(String s, String s2){
        System.out.println(s+" "+s2);
    }
    private SubSolution(String s, String s2, String s3){
        System.out.println(s+" "+s2+" "+s3);
    }

    protected SubSolution(boolean s)
    {
        super(s);
    }

    protected SubSolution(boolean s, boolean s2)
    {
        super(s, s2);
    }

    protected SubSolution(boolean s, boolean s2, boolean s3)
    {
        super(s, s2, s3);
    }
}
