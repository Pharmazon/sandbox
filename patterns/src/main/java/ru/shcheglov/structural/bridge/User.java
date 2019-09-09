package ru.shcheglov.structural.bridge;

public class User {

    private UserImpl realUser;

    public User(UserImpl impl) {
        realUser = impl;
    }

    public void run() { //бежать
        realUser.run();
    }

    public void fly() { //лететь
        realUser.fly();
    }

    public void transformToDonkey() {
        realUser = new UserDonkey();
    }

    public void transformToDragon() {
        realUser = new UserDragon();
    }
}
