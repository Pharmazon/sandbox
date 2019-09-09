package ru.alexeyshcheglov.parser.info;

import lombok.Getter;

public enum SellerInfo {
    AGENCY("Агентство"),
    SELLER_TYPE("Тип продавца"),
    SELLER_AGE("Возраст продавца"),
    SELLER_NAME("Контактное лицо"),
    ADDRESS("Адрес"),
    SELLER_PHONE("Телефон"),
    NOTICE_ACTIVE("Объявлений активно"),
    NOTICE_COMPLETED("Объявлений всего");

    @Getter
    private String key;

    SellerInfo(String key) {
        this.key = key;
    }
}
