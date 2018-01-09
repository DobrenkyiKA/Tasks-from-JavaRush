package com.javarush.task.task16.task1631;


import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    ImageReaderFactory(){}

    public static ImageReader getImageReader(ImageTypes e) {
        if (e == ImageTypes.BMP) return new BmpReader();
        if (e == ImageTypes.JPG) return new JpgReader();
        if (e == ImageTypes.PNG) return new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");

    }
}
