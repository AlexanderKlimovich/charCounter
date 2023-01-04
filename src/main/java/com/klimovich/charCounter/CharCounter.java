package com.klimovich.charCounter;

import java.util.Map;

public interface CharCounter {
    Map<Character, Long> count(String input);
}
