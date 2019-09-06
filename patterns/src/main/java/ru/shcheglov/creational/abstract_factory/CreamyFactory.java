package ru.shcheglov.creational.abstract_factory;

public class CreamyFactory implements AbstractFactory {

    @Override
    public Cake getCake() {
        return new CreamyCake();
    }

    @Override
    public MilkCocktail getMilkCocktail() {
        return new CreamyMilkCocktail();
    }
}
