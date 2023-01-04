package com.klimovich.charCounter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BaseCharCounter implements CharCounter {

    public Map<Character, Long> count(String input) {
        Optional.ofNullable(input).orElseThrow(() -> new IllegalArgumentException("Input String can't be null"));
        return input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
    }
}
