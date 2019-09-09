package ru.shcheglov.jaxb.parser;

import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * @author Alexey Shcheglov
 * @version dated 22.01.2019
 */

public interface Parser {

    Object getObject(File file, Class c) throws JAXBException;

    void saveObject(File file, Object o) throws JAXBException;

}
