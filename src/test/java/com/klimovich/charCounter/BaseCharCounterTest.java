package com.klimovich.charCounter;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseCharCounterTest {
    private BaseCharCounter baseCharCounter = new BaseCharCounter();

    @Test
    void charCounter_ShouldThrowIllegalArgumentException_WhenInputStringIsNull() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            baseCharCounter.count(null);
        });
        Assertions.assertEquals("Input String can't be null", exception.getMessage());
    }

    @Test
    void charCounter_ShouldReturnNotNullResult_WhenInputStringIsEmpty() {
        LinkedHashMap<Character, Long> expectedResult = new LinkedHashMap<>();
        Assertions.assertEquals(expectedResult, baseCharCounter.count(""));
    }

    @Test
    void charCounter_ShouldReturnNotNullResult_WhenInputStringIsOneChar() {
        LinkedHashMap<Character, Long> expectedResult = new LinkedHashMap<>();
        expectedResult.put('b', 1L);
        Assertions.assertEquals(expectedResult, baseCharCounter.count("b"));
    }

    @Test
    void charCounter_ShouldReturnNotNullResult_WhenInputStringIsOnlySameChars() {
        LinkedHashMap<Character, Long> expectedResult = new LinkedHashMap<>();
        expectedResult.put('b', 6L);
        Assertions.assertEquals(expectedResult, baseCharCounter.count("bbbbbb"));
    }

    @Test
    void charCounter_ShouldReturnNotNullResult_WhenInputStringIsOnlySpaces() {
        LinkedHashMap<Character, Long> expectedResult = new LinkedHashMap<>();
        expectedResult.put(' ', 3L);
        Assertions.assertEquals(expectedResult, baseCharCounter.count("   "));
    }

    @Test
    void charCounter_ShouldReturnNotNullResult_WhenInputStringIsNotAlphabeticChars() {
        LinkedHashMap<Character, Long> expectedResult = new LinkedHashMap<>();
        expectedResult.put('!', 1L);
        expectedResult.put('?', 1L);
        expectedResult.put('*', 1L);
        expectedResult.put('+', 1L);
        expectedResult.put('-', 1L);
        expectedResult.put('#', 1L);
        expectedResult.put('1', 1L);
        Assertions.assertEquals(expectedResult, baseCharCounter.count("!?*+-#1"));
    }

    @Test
    void charCounter_ShouldReturnNotNullResult_WhenInputStringIsTwoWords() {
        LinkedHashMap<Character, Long> expectedResult = new LinkedHashMap<>();
        expectedResult.put('b', 2L);
        expectedResult.put('A', 2L);
        expectedResult.put('c', 1L);
        expectedResult.put(' ', 1L);
        expectedResult.put('C', 1L);
        Assertions.assertEquals(expectedResult, baseCharCounter.count("bAc bCA"));
    }

}
