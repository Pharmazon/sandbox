package ru.shcheglov.structural.proxy;

public interface Bank {
    void setUserMoney(User user, double money);
    int getUserMoney(User user);
}
