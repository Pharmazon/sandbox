package ru.shcheglov.jaxb.parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author Alexey Shcheglov
 * @version dated 22.01.2019
 */

public class JaxbParser implements Parser {

    public Object getObject(final File file, final Class c) throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(c);
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller.unmarshal(file);
    }

    public void saveObject(final File file, final Object o) throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(o.getClass());
        final Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(o, file);
    }

}
