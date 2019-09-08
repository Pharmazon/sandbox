package ru.alexeyshcheglov.parser.notice;

import lombok.Data;
import lombok.ToString;
import ru.alexeyshcheglov.parser.util.Parser;

import java.time.LocalDateTime;

@Data
@ToString
public abstract class Notice {
    private String link;
    private String title;
    private int price;
    private int id;
    private LocalDateTime placedDateTime; //НЕДОПИСАНО
    private int watchesTotal;
    private int watchesToday;
    private String description;
    private String sellerName;
    private String sellerType;
    private Parser parser;

    Notice(String url) {
        this.link = url;
        this.parser = new Parser(url);
        this.title = parser.parseTitle();
        this.description = parser.parseDescription();
        this.price = parser.parsePrice();
        this.watchesToday = parser.parseWatchesToday();
        this.watchesTotal = parser.parseWatchesTotal();
        this.id = parser.parseId();
//        this.sellerType = parser.parseSellerType();
//        this.sellerName = parser.parseSellerName();
    }
}
