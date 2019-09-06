package ru.shcheglov.behavioral.state;

public class Main {

    public static void main(String[] args) {
        State open = new Open();
        Door door = new Door();
        door.setState(open);

        for (int i = 0; i < 10; i++) {
            door.move();
            door.changeState();
        }
    }
}






