package ru.shcheglov.structural.bridge;

public class Main {

    public static void main(String[] args) {
        User user = new User(new UserDonkey()); //внутри мы – осел
        user.transformToDragon(); //теперь внутри мы – дракон
    }
}
