package ru.alexeyshcheglov.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.alexeyshcheglov.parser.util.Link;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestParseToFile {
    public static void main(String[] args) throws IOException {
        final String parentLink = "https://www.avito.ru/tolyatti/kvartiry/kuplyu";
        final String rawFileName = "raw_data.csv";

        Path rawPath = Paths.get(rawFileName);

        Document docBasic = Jsoup.connect(Link.pageLink(parentLink, 1))
                .userAgent("Mozilla")
                .timeout(1000)
                .get();
        int[] pages = getAllPageNumbers(docBasic);

        checkTargetFile(rawPath, rawFileName);

        for (int i = 0; i < pages.length; i++) {
            String link = Link.pageLink(parentLink, pages[i]);
            Document doc = Jsoup.connect(link).userAgent("Mozilla")
                    .userAgent("Mozilla")
                    .timeout(1000)
                    .get();
            parseHtml(doc, rawFileName);
        }
    }

    public static void checkTargetFile(Path path, String fileName) {
        try {
            Files.deleteIfExists(Paths.get(fileName));
            if (!isFileExists(fileName)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isFileExists(String fileName) {
        Path path = Paths.get(fileName);
        return Files.exists(path);
    }

    public static boolean isLinkExistsInFile(String srcLink, String dstFile) {
        BufferedReader reader = null;
        if (!isFileExists(dstFile)) {
            return false;
        }
        srcLink = srcLink.trim();
        try {
            reader = new BufferedReader(new FileReader(dstFile));
            while (reader.ready()) {
                String dstLink = reader.readLine().trim();
                if (srcLink.equals(dstLink)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void printLinkToFile(String line, String fileName) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, true);
            if (isFileExists(fileName)) {
                writer.write(line + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int[] getAllPageNumbers(Document doc) {
        Elements pages = doc.getElementsByAttributeValue("class", "pagination-page");
        if (pages.size() == 0) {
            return new int[1];
        }

        int lastPageNum = 0;
        for (Element page : pages) {
            String url = page.attr("href");
            int startIndex = url.indexOf("p=") + 2;
            int endIndex = url.indexOf("&view");
            String st = url.substring(startIndex, endIndex);
            lastPageNum = Integer.parseInt(url.substring(startIndex, endIndex));
        }

        int[] pagesArray = new int[lastPageNum];
        for (int i = 0; i < pagesArray.length; i++) {
            pagesArray[i] = i + 1;
        }
        return pagesArray;
    }

    public static void parseHtml(Document doc, String fileName) {
        Elements noticeLink = doc.getElementsByAttributeValue("class", "h3 fader description-title-h3");

        noticeLink.forEach(linkItem -> {
            Element aElem = linkItem.child(0);
            String url = Link.fullLink(aElem.attr("href"));
            if (!isLinkExistsInFile(url, fileName)) {
                printLinkToFile(url, fileName);
            }
        });
    }
}
