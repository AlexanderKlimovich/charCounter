package com.klimovich.charCounter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class Cache {

    private Map<String, Map<Character, Long>> map;

    public Cache(int cacheSize) {

        this.map = new LinkedHashMap<String, Map<Character, Long>>(cacheSize, .75F, true) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean removeEldestEntry(Map.Entry<String, Map<Character, Long>> eldest) {
                return size() > cacheSize;
            }
        };
    }

    public Map<Character, Long> computeIfAbsent(String key,
            Function<? super String, ? extends Map<Character, Long>> mappingFunction) {
        return map.computeIfAbsent(key, mappingFunction);
    }

}
