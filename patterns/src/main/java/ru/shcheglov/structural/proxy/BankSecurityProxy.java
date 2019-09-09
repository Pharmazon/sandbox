package ru.shcheglov.structural.proxy;

public class BankSecurityProxy implements Bank {

    private Bank bank;

    public BankSecurityProxy(Bank bank) {
        this.bank = bank;
    }

    public void setUserMoney(User user, double money) {
        if (!SecurityManager.authorize(user, BankAccounts.Manager))
            throw new SecurityException("User can’t change money value");

        bank.setUserMoney(user, money);
    }

    public int getUserMoney(User user) {
        if (!SecurityManager.authorize(user, BankAccounts.Manager))
            throw new SecurityException("User can’t get money value");

        return bank.getUserMoney(user);
    }
}
