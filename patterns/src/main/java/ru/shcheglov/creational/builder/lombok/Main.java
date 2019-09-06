package ru.shcheglov.creational.builder.lombok;

public class Main {

    public static void main(String[] args) {

        Hero hero = Hero.builder()
                .className("Dark Elf")
                .name("Magician")
                .level(15)
                .hp(56)
                .maxHp(100)
                .build();

    }
}
