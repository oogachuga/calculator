package com.calculator;

import java.util.*;

public class EquationElements {

    private List<EquationElement> equationElements;

    public EquationElements(String input) {
        input = input.replaceAll("\\s", "");
        this.equationElements = buildElementList(input);
    }

    private List<EquationElement> buildElementList(String input) {

        List<String> elements = Arrays.asList(this.insertCommas(input).split(","));
        List<EquationElement> equationElements = new ArrayList<EquationElement>();

        for (String e: elements) {
            equationElements.add(new EquationElement(e));
        }

        return equationElements;
    }

    public List<EquationElement> getElements() {
        return this.equationElements;
    }

    public void moveElement(EquationElement e, int toIndex) {

    }

    public void removeElement() {

    }

    // another class
    private String insertCommas(String input) {

        StringBuilder sb = new StringBuilder();
        String s;

        for (int i = 0; i < input.length(); i++) {

            s = Character.toString(input.charAt(i));

            if (EquationString.isOperator(s)) {
                sb.append("," + input.charAt(i) + ",");
            }
            else if (EquationString.isOpeningBracket(s)) {
                sb.append(input.charAt(i) + ",");
            }
            else if (EquationString.isClosingBracket(s)) {
                sb.append("," + input.charAt(i));
            }
            else {
                sb.append(input.charAt(i));
            }
        }
        System.out.println("string builder = " + sb.toString());
        return sb.toString();
    }

}
