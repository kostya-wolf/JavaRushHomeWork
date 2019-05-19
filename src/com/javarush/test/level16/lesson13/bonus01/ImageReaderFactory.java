package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Волковы on 13.08.2016.
 */
public class ImageReaderFactory
{
    static ImageReader getReader(ImageTypes img){
        if (img == ImageTypes.JPG) return new JpgReader();
        else if (img == ImageTypes.PNG) return new PngReader();
        else if (img == ImageTypes.BMP) return new BmpReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
