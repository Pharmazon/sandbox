package ru.shcheglov.structural.proxy;

public class AuthManager {

    public static User authorize(String login, String password) {
        return new User();
    }
}
