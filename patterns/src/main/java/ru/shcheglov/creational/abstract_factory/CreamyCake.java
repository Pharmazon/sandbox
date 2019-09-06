package ru.shcheglov.creational.abstract_factory;

public class CreamyCake implements Cake {
    @Override
    public void printName() {
        System.out.println("Creamy cake");
    }

    @Override
    public void printPrice() {
        System.out.println(50);
    }
}
