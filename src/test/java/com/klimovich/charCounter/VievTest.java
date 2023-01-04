package com.klimovich.charCounter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VievTest {
    PrintStream standardOut = System.out;
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    Viev viev = new Viev();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void showResult_ShouldPrintToConsole_WhenInputStringIsEmpty() {
        Map<Character, Long> inputData = new LinkedHashMap<>();
        String expected = "";
        viev.showResult(inputData);
        Assertions.assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void showResult_ShouldPrintToConsole_WhenInputStringIsOneChar() {
        Map<Character, Long> inputData = new LinkedHashMap<>();
        inputData.put('b', 1L);
        String expected = new StringJoiner(System.lineSeparator())
                .add("\"b\" - 1")
                .toString();
        viev.showResult(inputData);
        Assertions.assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void showResult_ShouldPrintToConsole_WhenInputStringIsOnlySameChars() {
        Map<Character, Long> inputData = new LinkedHashMap<>();
        inputData.put('b', 3L);
        String expected = new StringJoiner(System.lineSeparator())
                .add("\"b\" - 3")
                .toString();
        viev.showResult(inputData);
        Assertions.assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void showResult_ShouldPrintToConsole_WhenInputStringIsOnlySpaces() {
        Map<Character, Long> inputData = new LinkedHashMap<>();
        inputData.put(' ', 3L);
        String expected = new StringJoiner(System.lineSeparator())
                .add("\" \" - 3")
                .toString();
        viev.showResult(inputData);
        Assertions.assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void showResult_ShouldPrintToConsole_WhenInputStringIsNotAlphabeticChars() {
        Map<Character, Long> inputData = new LinkedHashMap<>();
        inputData.put('!', 1L);
        inputData.put('?', 1L);
        inputData.put('*', 1L);
        inputData.put('+', 1L);
        inputData.put('-', 1L);
        inputData.put('#', 1L);
        inputData.put('1', 1L);
        String expected = new StringJoiner(System.lineSeparator())
                .add("\"!\" - 1")
                .add("\"?\" - 1")
                .add("\"*\" - 1")
                .add("\"+\" - 1")
                .add("\"-\" - 1")
                .add("\"#\" - 1")
                .add("\"1\" - 1")
                .toString();
        viev.showResult(inputData);
        Assertions.assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void showResult_ShouldPrintToConsole_WhenInputStringIsTwoWords() {
        Map<Character, Long> inputData = new LinkedHashMap<>();
        inputData.put('b', 2L);
        inputData.put('A', 2L);
        inputData.put('c', 1L);
        inputData.put(' ', 1L);
        inputData.put('C', 1L);
        String expected = new StringJoiner(System.lineSeparator())
                .add("\"b\" - 2")
                .add("\"A\" - 2")
                .add("\"c\" - 1")
                .add("\" \" - 1")
                .add("\"C\" - 1")
                .toString();
        viev.showResult(inputData);
        Assertions.assertEquals(expected, outputStreamCaptor.toString().trim());
    }
}
