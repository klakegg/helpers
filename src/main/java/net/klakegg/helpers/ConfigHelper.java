package net.klakegg.helpers;

import com.typesafe.config.Config;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConfigHelper {

    public static Optional<String> s(Config config, String path) {
        if (config.hasPath(path))
            return Optional.of(config.getString(path));
        return Optional.empty();
    }

    public static String s(Config config, String path, String defaultValue) {
        return s(config, path).orElse(defaultValue);
    }

    public static Optional<List<String>> sl(Config config, String path) {
        if (config.hasPath(path))
            return Optional.of(config.getStringList(path));
        return Optional.empty();
    }

    public static List<String> sl(Config config, String path, List<String> defaultValue) {
        return sl(config, path).orElse(defaultValue);
    }

    public static Optional<Boolean> b(Config config, String path) {
        if (config.hasPath(path))
            return Optional.of(config.getBoolean(path));
        return Optional.empty();
    }

    public static boolean b(Config config, String path, boolean defaultValue) {
        return b(config, path).orElse(defaultValue);
    }

    public static Optional<Integer> i(Config config, String path) {
        if (config.hasPath(path))
            return Optional.of(config.getInt(path));
        return Optional.empty();
    }

    public static int i(Config config, String path, int defaultValue) {
        return i(config, path).orElse(defaultValue);
    }

    public static Optional<Double> d(Config config, String path) {
        if (config.hasPath(path))
            return Optional.of(config.getDouble(path));
        return Optional.empty();
    }

    public static double d(Config config, String path, double defaultValue) {
        return d(config, path).orElse(defaultValue);
    }

    public static Optional<Long> l(Config config, String path) {
        if (config.hasPath(path))
            return Optional.of(config.getLong(path));
        return Optional.empty();
    }

    public static long l(Config config, String path, long defaultValue) {
        return l(config, path).orElse(defaultValue);
    }

    public static Optional<Number> n(Config config, String path) {
        if (config.hasPath(path))
            return Optional.of(config.getNumber(path));
        return Optional.empty();
    }

    public static Number n(Config config, String path, Number defaultValue) {
        return n(config, path).orElse(defaultValue);
    }

    public static Optional<Class<?>> c(Config config, String path) {
        if (config.hasPath(path))
            return Optional.of(ClassHelper.get(config.getString(path)));
        return Optional.empty();
    }

    public static Class<?> c(Config config, String path, Class<?> defaultValue) {
        return c(config, path).orElse(defaultValue);
    }

    public static Optional<List<Class<?>>> cl(Config config, String path) {
        if (config.hasPath(path))
            return Optional.of(config.getStringList(path).stream()
                    .map(ClassHelper::get)
                    .collect(Collectors.toList()));
        return Optional.empty();
    }

    public static List<Class<?>> cl(Config config, String path, List<Class<?>> defaultValue) {
        return cl(config, path).orElse(defaultValue);
    }
}
