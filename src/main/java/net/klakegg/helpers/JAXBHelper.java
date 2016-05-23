package net.klakegg.helpers;

import javax.xml.bind.JAXBContext;

public class JAXBHelper {

    public static JAXBContext context(Class... classes) {
        try {
            return JAXBContext.newInstance(classes);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
