package com.klimovich.charCounter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            CharCounter baseCharCounter = new BaseCharCounter();
            CharCounter cachingCharCounter = new CachedCharCounter(baseCharCounter, 10);
            Viev viev = new Viev();
            System.out.println("Enter a String, if you want close program write 'exit'");
            String input;
            do {
                input = scanner.nextLine();
                viev.showResult(cachingCharCounter.count(input));
            } while (!input.equals("exit"));
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

    }
}
