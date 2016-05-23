package net.klakegg.helpers;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import net.klakegg.helpers.lang.ClassException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigHelperTest {

    @Test
    public void simpleConstructor() {
        new ConfigHelper();
    }

    @Test
    public void testS() {
        Config config = ConfigFactory.parseString("value = Hello World");

        Assert.assertEquals(ConfigHelper.s(config, "value", "Bye bye"), "Hello World");
        Assert.assertEquals(ConfigHelper.s(config, "values", "Bye bye"), "Bye bye");
    }

    @Test
    public void testB() {
        Config config = ConfigFactory.parseString("value = true");

        Assert.assertEquals(ConfigHelper.b(config, "value", false), true);
        Assert.assertEquals(ConfigHelper.b(config, "values", false), false);
    }

    @Test
    public void testI() {
        Config config = ConfigFactory.parseString("value = 10");

        Assert.assertEquals(ConfigHelper.i(config, "value", 20), 10);
        Assert.assertEquals(ConfigHelper.i(config, "values", 20), 20);
    }

    @Test
    public void testL() {
        Config config = ConfigFactory.parseString("value = 10");

        Assert.assertEquals(ConfigHelper.l(config, "value", 20), 10);
        Assert.assertEquals(ConfigHelper.l(config, "values", 20), 20);
    }

    @Test
    public void testN() {
        Config config = ConfigFactory.parseString("value = 10");

        Assert.assertEquals(ConfigHelper.n(config, "value", 20), 10);
        Assert.assertEquals(ConfigHelper.n(config, "values", 20), 20);
    }

    @Test
    public void testD() {
        Config config = ConfigFactory.parseString("value = 10.5");

        Assert.assertEquals(ConfigHelper.d(config, "value", 20.5), 10.5);
        Assert.assertEquals(ConfigHelper.d(config, "values", 20.5), 20.5);
    }

    @Test
    public void testC() {
        Config config = ConfigFactory.parseString("value = net.klakegg.helpers.lang.ClassException");

        Assert.assertEquals(ConfigHelper.c(config, "value", ClassHelper.class), ClassException.class);
        Assert.assertEquals(ConfigHelper.c(config, "values", ClassHelper.class), ClassHelper.class);
    }

}
