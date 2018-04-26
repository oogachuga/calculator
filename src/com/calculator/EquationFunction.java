package com.calculator;

public enum EquationFunction {
    SINE        ("SINE"),
    COSINE      ("COSINE"),
    TANGENT     ("TANGENT"),
    EXPONENT    ("EXPONENT"),
    CUSTOM_FUNCTION ("CF");

    private final String function;

    EquationFunction(String function) {
        this.function = function;
    }

    public String getString() {
        return this.function;
    }
}
