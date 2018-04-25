package com.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        EquationElements elements;
        String input;

        while(inputScanner.hasNext()) {

            input = inputScanner.nextLine();
            calculator.solve(new EquationElements(input));

            if (input.equals("exit")) {
                break;
            }
        }

    }

}
