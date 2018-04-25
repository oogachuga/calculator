package com.calculator;

public enum EquationPart {

    OPENING_BRACKET     ("("),
    CLOSING_BRACKET     (")"),
    OPERATOR_ADD        ("+"),
    OPERATOR_SUBTRACT   ("-"),
    OPERATOR_MULTIPLY   ("*"),
    OPERATOR_DIVIDE     ("/"),

    ELEMENT_TYPE_OPERATOR       ("OPERATOR"),
    ELEMENT_TYPE_NUMBER         ("NUMBER"),
    ELEMENT_TYPE_BRACKET_OPEN   ("BRACKET_OPEN"),
    ELEMENT_TYPE_BRACKET_CLOSE  ("BRACKET_CLOSE"),
    ELEMENT_TYPE_FUNCTION       ("FUNCTION"),

    ELEMENT_OP_ADD        ("ADD"),
    ELEMENT_OP_SUBTRACT   ("SUBTRACT"),
    ELEMENT_OP_MULTIPLY   ("MULTIPLY"),
    ELEMENT_OP_DIVIDE     ("DIVIDE");

    private final String element;

    EquationPart(String element) {
        this.element = element;
    }

    public String getString() {
        return this.element;
    }

}
