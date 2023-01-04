package com.klimovich.charCounter;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CachedCharCounterTest {

    @Mock
    private BaseCharCounter baseCharCounter;
    @InjectMocks
    private CachedCharCounter cachedCharCounter = new CachedCharCounter(baseCharCounter, 2);

    @Test
    void charCounter_ShouldReturnDataFromCache_WhenInputStringNotPresentInCache() {
        LinkedHashMap<Character, Long> result = new LinkedHashMap<>();
        result.put('a', 4L);
        when(baseCharCounter.count("aaaa")).thenReturn(result);
        cachedCharCounter.count("aaaa");
        verify(baseCharCounter).count("aaaa");
    }

    @Test
    void charCounter_ShouldReturnDataFromCache_WhenInputStringIsPresentInCache() {
        LinkedHashMap<Character, Long> result = new LinkedHashMap<>();
        result.put('a', 4L);
        when(baseCharCounter.count("aaaa")).thenReturn(result);
        cachedCharCounter.count("aaaa");
        cachedCharCounter.count("aaaa");
        verify(baseCharCounter, times(1)).count("aaaa");
    }

    @Test
    void charCounter_ShouldRemoveObjectFromCache_WhenCacheHaveMaxSize() {
        cachedCharCounter.count("a");
        cachedCharCounter.count("b");
        cachedCharCounter.count("c");
        cachedCharCounter.count("a");
        verify(baseCharCounter, times(2)).count("a");
    }

}
