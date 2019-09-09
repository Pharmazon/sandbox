package ru.shcheglov.structural.proxy;

public class SecurityManager {

    public static boolean authorize(User user, BankAccounts accounts) {
        return true;
    }
}
