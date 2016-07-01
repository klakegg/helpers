package net.klakegg.helpers;

import net.klakegg.helpers.lang.JAXBHelperException;

import javax.xml.bind.JAXBContext;

public class JAXBHelper {

    public static JAXBContext context(Class... classes) {
        try {
            return JAXBContext.newInstance(classes);
        } catch (Exception e) {
            throw new JAXBHelperException(e.getMessage(), e);
        }
    }
}
