package ru.shcheglov.behavioral.strategy;

public class OpenA implements Strategy {

    @Override
    public void openClose() {
        System.out.println("Дверь открыта.");
    }
}
