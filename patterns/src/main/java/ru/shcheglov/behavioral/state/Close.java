package ru.shcheglov.behavioral.state;

public class Close implements State {

    @Override
    public void openClose() {
        System.out.println("Дверь закрыта.");
    }
}
