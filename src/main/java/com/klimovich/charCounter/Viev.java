package com.klimovich.charCounter;

import java.util.Map;

public class Viev {
    void showResult(Map<Character, Long> input) {
        input.entrySet()
                .stream()
                .map(entry -> String.format("\"%s\" - %d", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);

    }
}
