package com.calculator;

import java.util.Arrays;
import java.util.List;

public final class EquationString {

    // TODO: move this to EquationPart?

    public static boolean isOperator(String s) {

        List<String> opList = Arrays.asList("+", "-", "*", "/");

        if (opList.contains(s)) {
            return true;
        }

        return false;
    }

    public static boolean isOpeningBracket(String s) {

        List<String> brackets = Arrays.asList("(");

        if (brackets.contains(s)) {
            return true;
        }

        return false;
    }

    public static boolean isClosingBracket(String s) {

        List<String> brackets = Arrays.asList(")");

        if (brackets.contains(s)) {
            return true;
        }

        return false;
    }

    public static boolean isFunction(String s) {

        // consider functions with expressions sin(1 + 2 + 3 + cos(3)), x^2 is an exception case of functions
        // could use solve() in this class, or solve in calculator class then not have expressions as params here

        List<String> functions = Arrays.asList("sin", "cos", "tan");

        if (functions.contains(s) || s.contains("^")) {
            return true;
        }

        return false;
    }

    public static boolean isNumeric(String s)
    {
        try {
            double d = Double.parseDouble(s);
        }
        catch(NumberFormatException nfe) {
            return false;
        }

        return true;
    }



}
