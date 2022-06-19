package ru.levelp.at.utils;

import java.util.concurrent.TimeUnit;

public final class SleepUtils {

    private SleepUtils() {
    }

    public static void sleep(long timeoutMs) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeoutMs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}