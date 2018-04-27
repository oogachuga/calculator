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
            // if a part of the equation is not an operator, bracket or number then it must be a function
            else if (isNumeric(s)) {
                sb.append(input.charAt(i));
            }
            else if (!s.equals(",")) {
                String function = extractFunctionName(input, i);

                sb.append(function);
                i = i + function.length() - 1;
            }
        }

        return sb.toString().replace(",,", ",");
    }

    // convert custom function to calculator input
    // 1+sine(2 + 3 + cf(1 + 2, 3, cf(4, 5, 6)) ) * 10
    private static String convertFunctions(String input) {
        String s, function, parameters;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                function = extractFunctionName(input, i);
                parameters = extractBrackets(input, i + function.length() + 1);
                // remove unprocessed function, add new function


            }
        }

        return "";
    }

    //
    private static String extractBrackets(String equation, int start) {
        int unclosedBrackets = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = start; i < equation.length(); i++) {
            if (isOpeningBracket(Character.toString(equation.charAt(i)))) {
                unclosedBrackets++;
            }
            else if (isClosingBracket(Character.toString(equation.charAt(i)))) {
                if (unclosedBrackets == 0) {
                    return sb.toString();
                }
                unclosedBrackets--;
            }
            sb.append(Character.toString(equation.charAt(i)));
        }

        return null;
    }

    private static boolean isCustomFunction(String functionName) {
        // check a list
        return true;
    }

    private static String customFunction(String parameters) {
        // split parameters commas
        // build string with parameters
        // done
        return "";
    }

    private static String extractFunctionName(String equation, int startIndex) {
        StringBuilder sb = new StringBuilder();
        String s;

        for (int i = 0; i < equation.length() - (startIndex + 1); i++) {
            s = Character.toString(equation.charAt(startIndex + i));
            if (isOperator(s) || isOpeningBracket(s) || isClosingBracket(s) || isNumeric(s)) {
                return sb.toString();
            }
            //System.out.println("extracting = " + s);
            sb.append(s);
        }

        System.out.println("------------");
        return sb.toString();
    }



    public static List<String> getElements(String input) {
        input = input.replaceAll("\\s", "");
        convertFunctions(input);
        return Arrays.asList(insertCommas(input).split(","));
    }

}
