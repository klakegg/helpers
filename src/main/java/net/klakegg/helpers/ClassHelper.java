package net.klakegg.helpers;

import net.klakegg.helpers.lang.ClassException;

public class ClassHelper {

    public static Class<?> get(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new ClassException(String.format("Unable to load class '%s'.", className), e);
        }
    }

    public static Class<?> get(String className, String fallback) {
        try {
            return get(className);
        } catch (ClassException e) {
            return get(fallback);
        }
    }

    public static Class<?> get(String className, Class<?> fallback) {
        try {
            return get(className);
        } catch (ClassException e) {
            return fallback;
        }
    }

    public static <T> T instance(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ClassException(String.format("Unable to create instance of '%s'.", cls), e);
        }
    }
}
