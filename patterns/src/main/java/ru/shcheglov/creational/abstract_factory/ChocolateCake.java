package ru.shcheglov.creational.abstract_factory;

public class ChocolateCake implements Cake {
    @Override
    public void printName() {
        System.out.println("Chocolate cake");
    }

    @Override
    public void printPrice() {
        System.out.println(30);
    }
}
