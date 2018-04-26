package com.calculator;

public enum EquationPart {

    OPENING_BRACKET     ("("),
    CLOSING_BRACKET     (")"),

    ELEMENT_TYPE_OPERATOR       ("OPERATOR"),
    ELEMENT_TYPE_NUMBER         ("NUMBER"),
    ELEMENT_TYPE_BRACKET_OPEN   ("BRACKET_OPEN"),
    ELEMENT_TYPE_BRACKET_CLOSE  ("BRACKET_CLOSE"),
    ELEMENT_TYPE_FUNCTION       ("FUNCTION");

    private final String part;

    EquationPart(String part) {
        this.part = part;
    }

    public String getString() {
        return this.part;
    }
}
