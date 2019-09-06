package ru.shcheglov.creational.factory_method;

public class FactoryMethod {

    public static void main(String[] args) {
        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
    }

}
