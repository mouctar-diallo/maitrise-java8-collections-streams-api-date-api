package io.focati.java8.tools.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AssertUtils {
    public static <T> boolean isLambda(T e) {
        return e.getClass().getSimpleName().contains("$$Lambda");
    }
}
