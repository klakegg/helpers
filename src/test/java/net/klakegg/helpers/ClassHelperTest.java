package net.klakegg.helpers;

import net.klakegg.helpers.lang.ClassException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassHelperTest {

    @Test
    public void simpleConstructor() {
        Assert.assertNotNull(ClassHelper.instance(ClassHelper.class));
    }

    @Test
    public void simpleExistingClass() {
        Assert.assertNotNull(ClassHelper.get(ClassHelper.class.getName()));
    }

    @Test(expectedExceptions = ClassException.class)
    public void simpleNonExistingClass() {
        ClassHelper.get("no.class");
    }

    @Test
    public void simpleStringFallback() {
        Assert.assertEquals(ClassHelper.get(ClassHelper.class.getName(), "should.not.trigger"), ClassHelper.class);
        Assert.assertEquals(ClassHelper.get("should.not.trigger", ClassHelper.class.getName()), ClassHelper.class);
    }

    @Test
    public void simpleClassFallback() {
        Assert.assertEquals(ClassHelper.get(ClassHelper.class.getName(), ClassException.class), ClassHelper.class);
        Assert.assertEquals(ClassHelper.get("should.not.trigger", ClassHelper.class), ClassHelper.class);
    }

    @Test(expectedExceptions = ClassException.class)
    public void simpleFailingInstance() {
        ClassHelper.instance(ClassException.class);
    }
}
