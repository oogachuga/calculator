package com.calculator;

import java.util.Arrays;
import java.util.List;

// todo: change to non static methods
// todo: a custom function string class
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

            if (EquationString.isOperator(s) || EquationString.isOpeningBracket(s)) {
                sb.append("," + input.charAt(i) + ",");
            }
            else if (EquationString.isClosingBracket(s)) {
                sb.append("," + input.charAt(i));
            }
            else if (isNumeric(s)) {
                sb.append(input.charAt(i));
            }
            else if (!s.equals(",")) {
                String functionName = extractFunctionName(input, i);
                System.out.println("FUNCTION NAME: " + functionName);

                if (functionName.equals("cf")) {
                    String extraction = extractBrackets(input, i + functionName.length());
                    convertFunction(functionName + extraction);
                    i = i + extraction.length(); // i--;
                }
                else {
                    // functions always preceded by op or opening bracket so no commas needed
                    sb.append(functionName);
                    i = i + functionName.length() - 1;
                }
            }
        }

        return sb.toString().replace(",,", ",");
    }

    // 1+sine(2+3+cf(abc(1+2)+def(1,2)*10,3,2+cf(4,5,6)))*10
    // input is entire cf string 'cfn(...)'
    private static String convertFunction(String customFunction) {
        // split parameters
        // each parameters, if parameter is cfn, parameter x = convert(cfn(...))
        // now there is no cfn in parameters so this cfn can build the string from parameters
        // function string = db.find(cfn) -> build string with parameters
        // return string built
        System.out.println("convertFunction input: " + customFunction);

        String functionName = extractFunctionName(customFunction, 0);
        customFunction = customFunction.substring(functionName.length() + 1, customFunction.length() - 1); // remove function name and brackets
        String bracketsConverted = replaceBracketCommas(customFunction); // commas in brackets converted so parameters can be split
        List<String> parameters = Arrays.asList(bracketsConverted.split(","));

        for (String parameter: parameters) {
            parameter = parameter.replace("@", ",");
            System.out.println("parameter = " + parameter);
            if (hasCustomFunction(parameter)) {
                System.out.println("parameter: " + parameter + " has a custom function");

            }
        }

        /*      parameter: abc(1+2)+def(1,2)*10
                parameter: 3
                parameter: cf(4,5,6)
         */

        return "";
    }

    private static String extractFunctionName(String equation, int startIndex) {
        StringBuilder sb = new StringBuilder();
        String s;

        for (int i = startIndex; i < equation.length(); i++) {
            s = Character.toString(equation.charAt(i));
            if (isOperator(s) || isOpeningBracket(s) || isClosingBracket(s) || isNumeric(s)) {
                return sb.toString();
            }

            sb.append(s);
        }

        return sb.toString();
    }

    // find custom user functions (not sine cosine exp etc)
    private static boolean hasCustomFunction(String input) {
        String s;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            s = Character.toString(input.charAt(i));
            if (Character.isLetter(input.charAt(i))) {
                if (isCustomFunction(extractFunctionName(input, i))) {
                    return true;
                }
            }

        }
        return false;
    }

    // temporary solution
    private static boolean isCustomFunction(String function) {
        if (function.equals("sine") || function.equals("cosine")) {
            return false;
        }
        return true;
    }

    // replace commas inside brackets so the string can be used by the function converter
    private static String replaceBracketCommas(String input) {
        StringBuilder sb = new StringBuilder();
        String s;
        for (int i = 0; i < input.length(); i++) {
            s = Character.toString(input.charAt(i));
            if (s.equals(",") && inBrackets(input, i)) {
                sb.append("@");
            }
            else {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    private static boolean inBrackets(String function, int index) {
        int unclosedBrackets = 0;

        for (int i = 0; i < function.length(); i++) {
            if (isOpeningBracket(Character.toString(function.charAt(i)))) {
                unclosedBrackets++;
            }
            else if (isClosingBracket(Character.toString(function.charAt(i)))) {
                unclosedBrackets--;
            }

            if (i == index && unclosedBrackets > 0) {
                return true;
            }
        }

        return false;
    }

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

    private static String customFunction(String parameters) {
        // split parameters commas
        // build string with parameters
        // done
        return "";
    }

    public static List<String> getElements(String input) {
        input = input.replaceAll("\\s", "");
        return Arrays.asList(insertCommas(input).split(","));
    }

}
