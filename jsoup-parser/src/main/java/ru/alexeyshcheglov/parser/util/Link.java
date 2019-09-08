package ru.alexeyshcheglov.parser.util;

public class Link {

    public static String fullLink(String link) {
        return "https://www.avito.ru" + link;
    }

    public static String pageLink(String link, int page) {
        return link + "?p=" + page + "&view=list";
    }
}
