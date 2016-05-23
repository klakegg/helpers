package net.klakegg.helpers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class JAXBHelper {

    public static JAXBContext context(Class... classes) {
        try {
            return JAXBContext.newInstance(classes);
        } catch (JAXBException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
