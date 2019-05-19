package com.javarush.test.level18.lesson08.task03;

import java.io.*;
import java.nio.channels.FileChannel;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";

    private FileOutputStream fos;

    public AmigoOutputStream(FileOutputStream fos) throws FileNotFoundException
    {
        super(fileName);
        this.fos = fos;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public AmigoOutputStream(String name) throws FileNotFoundException
    {
        super(name);
    }

    public AmigoOutputStream(String name, boolean append) throws FileNotFoundException
    {
        super(name, append);
    }

    public AmigoOutputStream(File file) throws FileNotFoundException
    {
        super(file);
    }

    public AmigoOutputStream(File file, boolean append) throws FileNotFoundException
    {
        super(file, append);
    }

    public AmigoOutputStream(FileDescriptor fdObj)
    {
        super(fdObj);
    }

    @Override
    public void write(int b) throws IOException
    {
        fos.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        fos.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        fos.write(b, off, len);
    }

    @Override
    public void close() throws IOException
    {
        fos.flush();
        fos.write("JavaRush © 2012-2013 All rights reserved.".getBytes());
        fos.close();
    }

    @Override
    public FileChannel getChannel()
    {
        return fos.getChannel();
    }

    @Override
    protected void finalize() throws IOException
    {
        super.finalize();
    }

    @Override
    public void flush() throws IOException
    {
        fos.flush();
    }

    @Override
    public int hashCode()
    {
        return fos.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return fos.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public String toString()
    {
        return fos.toString();
    }
}

