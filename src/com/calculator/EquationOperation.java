package com.calculator;

public enum EquationOperation {

    ADD        ("+"),
    SUBTRACT   ("-"),
    MULTIPLY   ("*"),
    DIVIDE     ("/");

    private final String part;

    EquationOperation(String part) {
        this.part = part;
    }

    public String getString() {
        return this.part;
    }
}
