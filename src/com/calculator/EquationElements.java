package com.calculator;

import java.util.*;

public class EquationElements {

    private List<EquationElement> equationElements;

    public EquationElements(String input) {
        this.equationElements = buildElementList(input);
    }

    private List<EquationElement> buildElementList(String input) {
        List<String> elements = EquationString.getElements(input);
        List<EquationElement> equationElements = new ArrayList<>();

        for (String e: elements) {
            equationElements.add(new EquationElement(e));
        }

        return equationElements;
    }

    public List<EquationElement> getElements() {
        return this.equationElements;
    }



}
