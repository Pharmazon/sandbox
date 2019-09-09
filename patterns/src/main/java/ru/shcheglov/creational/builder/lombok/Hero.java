package ru.shcheglov.creational.builder.lombok;

import lombok.Builder;

@Builder
public class Hero {

    private String className;
    private String name;
    private int level;
    private int hp;
    private int maxHp;

}
