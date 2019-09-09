package ru.shcheglov.structural.proxy;

public class BankFactory {

    public static Bank createUserBank(User user) {
        return new Bank() {
            @Override
            public void setUserMoney(User user, double money) {

            }

            @Override
            public int getUserMoney(User user) {
                return 2000;
            }
        };
    }
}
