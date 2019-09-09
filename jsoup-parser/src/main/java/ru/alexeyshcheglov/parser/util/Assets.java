package ru.alexeyshcheglov.parser.util;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Assets {
    private static Assets instance;

    private final Properties PROPERTIES;

    @Getter
    private final Parser PARSER;

    @Getter
    private final Logger LOGGER;

    @Getter
    private String url;

    private Assets() {
        PROPERTIES = new Properties();
        this.readProperties();
        PARSER = new Parser(url);
        LOGGER = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    }

    public static synchronized Assets getInstance() {
        if (instance == null) {
            instance = new Assets();
        }
        return instance;
    }

    private void readProperties() {
        try (InputStream in = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("config.properties")) {
            this.PROPERTIES.load(in);
            this.url = PROPERTIES.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
