package ru.shcheglov.structural.proxy;

public class Main {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        //Код без проверки безопасности:
        User user = AuthManager.authorize(LOGIN, PASSWORD);
        Bank bank = BankFactory.createUserBank(user);
        bank.setUserMoney(user, 1000000);

        //Код с включённой проверкой безопасности:
        User user1 = AuthManager.authorize(LOGIN, PASSWORD);
        Bank bank1 = BankFactory.createUserBank(user1);
        bank1 = new BankSecurityProxy(bank1);
        bank1.setUserMoney(user, 1000000);
    }
}
