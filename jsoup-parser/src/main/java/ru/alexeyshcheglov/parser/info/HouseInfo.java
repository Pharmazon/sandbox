package ru.alexeyshcheglov.parser.info;

import lombok.Getter;

public enum HouseInfo {
    FLOOR("Этаж"),
    TOTAL_FLOORS("Этажей в доме"),
    HOUSE_TYPE("Тип дома"),
    ROOMS_COUNT("Количество комнат"),
    AREA_TOTAL("Общая площадь"),
    AREA_KITCHEN("Площадь кухни"),
    AREA_LIVING("Жилая площадь"),
    PARTICIPATION_TYPE("Тип участия"),
    DEVELOPER("Официальный застройщик"),
    OBJECT_NAME("Название объекта недвижимости"),
    BUILDING_NUMBER("Корпус, строение");

    @Getter
    private String key;

    HouseInfo(String key) {
        this.key = key;
    }
}
