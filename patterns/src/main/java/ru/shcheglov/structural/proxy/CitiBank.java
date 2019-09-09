package ru.shcheglov.structural.proxy;

public class CitiBank implements Bank {

    public void setUserMoney(User user, double money) {
        UserDAO.updateMoney(user, money);
    }

    public int getUserMoney(User user) {
        return UserDAO.getMoney(user);
    }
}
