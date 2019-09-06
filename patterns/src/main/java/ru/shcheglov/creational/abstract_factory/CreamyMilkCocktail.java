package ru.shcheglov.creational.abstract_factory;

public class CreamyMilkCocktail implements MilkCocktail {
    @Override
    public void printName() {
        System.out.println("Creamy milk cocktail");
    }

    @Override
    public void printPrice() {
        System.out.println(125);
    }
}
