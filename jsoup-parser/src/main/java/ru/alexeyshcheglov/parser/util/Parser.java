package ru.alexeyshcheglov.parser.util;

import com.sun.istack.internal.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.alexeyshcheglov.parser.entity.*;
import ru.alexeyshcheglov.parser.info.HouseInfo;
import ru.alexeyshcheglov.parser.info.SellerInfo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    private Document document;

    public Parser(@NotNull final String url) {
        this.connect(url);
    }

    private void connect(String url) {
        try {
            this.document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Element parseElement(@NotNull final String value, @NotNull final byte[] children) {
        Element element = null;
        Elements elems = document.getElementsByAttributeValue("class", value);
        for (Element elem : elems) {
            for (int i = 0; i < children.length; i++) {
                if (element == null)
                    element = elem;
                element = element.child(children[i]);
            }
        }
        return element;
    }

    public String parseTitle() {
        Element element = parseElement("title-info-main", new byte[]{0, 0});
        return element.ownText();
    }

    public int parsePrice() {
        Element element = parseElement("item-price-value-wrapper", new byte[]{0, 0, 1});
        int price = Integer.parseInt(element.attr("content"));
        return price;
    }

    public String parseDescription() {
        Element element = parseElement("item-description", new byte[]{0, 0});
        return element.ownText();
    }

    public int parseId() {
        Element element = parseElement("title-info-metadata", new byte[]{0});
        String data = element.ownText();
        int startIndex = data.indexOf("№") + 2;
        int endIndex = data.indexOf(",");
        int id = Integer.parseInt(data.substring(startIndex, endIndex));
        return id;
    }

    public LocalDateTime parseDateTime() {
        Element element = parseElement("title-info-metadata", new byte[]{0});
        String data = element.ownText();

        int index = data.indexOf(",") + 12;
        String raw = data.substring(index);

        int ind = raw.indexOf(":");
        String time = raw.substring(ind - 2, ind + 3);
        LocalTime placedTime = LocalTime.parse(time);

        int indx = raw.indexOf(" в ");
        String date = raw.substring(0, indx);

        LocalDate placedDate = null;
        LocalDate today = LocalDate.now();
        if (date.equals("сегодня")) {
            placedDate = today;
        }
        if (date.equals("вчера")) {
            placedDate = LocalDate.of(today.getYear(), today.getMonth(), today.getDayOfMonth() - 1);
        }

        return LocalDateTime.of(placedDate, placedTime);
    }

    public int parseWatchesTotal() {
        Element element = parseElement("title-info-metadata-item title-info-metadata-views", new byte[]{1});
        String data = element.ownText();
        int index = data.indexOf(" ");
        return Integer.parseInt(data.substring(0, index));
    }

    public int parseWatchesToday() {
        Element element = parseElement("title-info-metadata-item title-info-metadata-views", new byte[]{1});
        String data = element.ownText();
        int index = data.indexOf("+") + 1;
        return Integer.parseInt(data.substring(index, data.length() - 1));
    }

    public Map<String, String> parseSellerInfo() {
        Map<String, String> map = new HashMap<>();
        Address noticeAddress = null;
        String classKey = "item-view-seller-info";
        String agency = parseElement(classKey, new byte[]{0, 0, 0, 0, 0, 0}).ownText();
        String sellerType = parseElement(classKey, new byte[]{0, 0, 0, 1}).ownText();
        String contact = parseElement(classKey, new byte[]{0, 2 , 1}).ownText();

        String noticesActiveParsed = parseElement(classKey, new byte[]{0, 1}).ownText();
        String[] dataNoticesActive = noticesActiveParsed.split(" ");
        String noticesActive = dataNoticesActive[0];

        String noticesCompletedParsed = parseElement(classKey, new byte[]{0, 0, 0, 2, 1}).ownText();
        String[] dataNoticesCompleted = noticesCompletedParsed.split(" ");
        String noticesCompleted = dataNoticesCompleted[1];

        String address = parseElement(classKey, new byte[]{0, 3, 1}).ownText();
        String[] dataAddress = address.split(", ");
        if (dataAddress.length == 4) {
            noticeAddress = new Address(0, new Region(dataAddress[0]), new City(dataAddress[1]),
                    null, new Street(dataAddress[2]), Integer.parseInt(dataAddress[3]));
        }
        if (dataAddress.length == 5) {
            noticeAddress = new Address(0, new Region(dataAddress[0]), new City(dataAddress[1].trim()),
                    new District(dataAddress[2]), new Street(dataAddress[3]), Integer.parseInt(dataAddress[4]));
        }

        String sellerAgeParsed = parseElement(classKey, new byte[]{0, 0, 0, 2, 0}).ownText();
        String[] dataSellerAge = sellerAgeParsed.split(" ");
        LocalDate sellerAge = preProcessAge(dataSellerAge);

        map.put(SellerInfo.AGENCY.getKey(), agency);
        map.put(SellerInfo.SELLER_TYPE.getKey(), sellerType);
        map.put(SellerInfo.SELLER_AGE.getKey(), sellerAge.toString());
        map.put(SellerInfo.SELLER_NAME.getKey(), contact);
        map.put(SellerInfo.ADDRESS.getKey(), noticeAddress == null ? "" : noticeAddress.toString());
        map.put(SellerInfo.NOTICE_ACTIVE.getKey(), noticesActive);
        map.put(SellerInfo.NOTICE_COMPLETED.getKey(), noticesCompleted);
        return map;
    }

    private LocalDate preProcessAge(String[] dataAge) {
        int result = 0;
        switch (dataAge[3]) {
            case "января":
                result = 1;
                break;
            case "февраля":
                result = 2;
                break;
            case "марта":
                result = 3;
                break;
            case "апреля":
                result = 4;
                break;
            case "мая":
                result = 5;
                break;
            case "июня":
                result = 6;
                break;
            case "июля":
                result = 7;
                break;
            case "августа":
                result = 8;
                break;
            case "сентября":
                result = 9;
                break;
            case "октября":
                result = 10;
                break;
            case "ноября":
                result = 11;
                break;
            case "декабря":
                result = 12;
                break;
        }
        return LocalDate.of(Integer.parseInt(dataAge[4]), result, 1);
    }

    public Map<String, String> parseHouseParameters() {
        Map<String, String> map = new HashMap<>();
        Elements elems = document.getElementsByAttributeValue("class", "item-params-list");
        int size = 0;
        for (Element elem : elems) {
            size = elem.children().size();
        }
        for (int i = 0; i < size; i++) {
            for (Element elem : elems) {
                String temp = elem.child(i).child(0).ownText();
                String key = temp.substring(0, temp.length() - 1);
                String value = elem.child(i).ownText();
                if (isKeyValid(key))
                    map.put(key, value);
            }
        }
        return map;
    }

    private boolean isKeyValid(String key) {
        HouseInfo[] houseInfos = HouseInfo.values();
        for (int i = 0; i < houseInfos.length; i++) {
            if (houseInfos[i].getKey().equals(key))
                return true;
        }
        return false;
    }
}
