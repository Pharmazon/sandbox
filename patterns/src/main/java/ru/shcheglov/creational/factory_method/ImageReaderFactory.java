package ru.shcheglov.creational.factory_method;

public class ImageReaderFactory {

    static ImageReader getImageReader(ImageTypes imtp) throws IllegalArgumentException {
        if (imtp == ImageTypes.BMP)
            return new BmpReader();
        if (imtp == ImageTypes.JPG)
            return new JpgReader();
        if (imtp == ImageTypes.PNG)
            return new PngReader();
        throw new IllegalArgumentException("Неизвестный тип картинки");
    }

}
