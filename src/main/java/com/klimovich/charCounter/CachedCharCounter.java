package com.klimovich.charCounter;

import java.util.Map;

public class CachedCharCounter implements CharCounter {

    private CharCounter charCounter;
    private Cache cache;

    public CachedCharCounter(CharCounter charCounter, int cacheSize) {
        this.charCounter = charCounter;
        this.cache = new Cache(cacheSize);
    }

    public Map<Character, Long> count(String input) {
        return cache.computeIfAbsent(input, charCounter::count);
    }

}
