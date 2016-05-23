package net.klakegg.helpers;

import org.testng.annotations.Test;

public class JAXBHelperTest {

    @Test
    public void simpleConstructor() {
        new JAXBHelper();
    }

    @Test
    public void simpleValidClass() {
        JAXBHelper.context(Object.class);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void simpleInvalidClass() {
        JAXBHelper.context(null);
    }
}
