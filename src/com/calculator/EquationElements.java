package com.calculator;

import java.util.*;

public class EquationElements {

    private List<EquationElement> equationElements;

    public EquationElements(String input) {
        this.equationElements = buildElementList(input);
    }

    private List<EquationElement> buildElementList(String input) {
        List<String> elements = EquationString.getElements(input);
        System.out.println("elements with commas = " + elements);
        List<EquationElement> equationElements = new ArrayList<>();

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

}
