package com.calculator;

import java.util.Arrays;
import java.util.List;

public class EquationString {

    public static boolean isOperator(String s) {
        List<String> opList = Arrays.asList(EquationOperation.ADD.getString(), EquationOperation.SUBTRACT.getString(), EquationOperation.MULTIPLY.getString(), EquationOperation.DIVIDE.getString());

        if (opList.contains(s)) {
            return true;
        }

        return false;
    }

    public static boolean isOpeningBracket(String s) {
        if (s.equals(EquationPart.OPENING_BRACKET.getString())) {
            return true;
        }

        return false;
    }

    public static boolean isClosingBracket(String s) {
        if (s.equals(EquationPart.CLOSING_BRACKET.getString())) {
            return true;
        }

        return false;
    }

    public static boolean isFunction(String s) {
        List<String> functions = Arrays.asList(EquationFunction.SINE.getString(), EquationFunction.COSINE.getString(), EquationFunction.TANGENT.getString(), EquationFunction.EXPONENT.getString(), EquationFunction.CUSTOM_FUNCTION.getString());

        for (String function: functions) {
            if (s.toUpperCase().contains(function)) {
                return true;
            }
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

    // Don't know how many digits a number may have so only insert commas at operators and brackets
    private static String insertCommas(String input) {
        StringBuilder sb = new StringBuilder();
        String s;

        System.out.println("input = " + input);

        for (int i = 0; i < input.length(); i++) {
            s = Character.toString(input.charAt(i));

            if (EquationString.isOperator(s)) {
                sb.append("," + input.charAt(i) + ",");
            }
            else if (EquationString.isOpeningBracket(s)) {
                sb.append("," + input.charAt(i) + ",");
            }
            else if (EquationString.isClosingBracket(s)) {
                sb.append("," + input.charAt(i));
            }
            else {
                sb.append(input.charAt(i));
            }
        }


        return sb.toString().replace(",,", ",");
    }

    public static List<String> getElements(String input) {
        input = input.replaceAll("\\s", "");
        return Arrays.asList(insertCommas(input).split(","));
    }

}
