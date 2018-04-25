package com.calculator;


public class EquationElement {

    private double value;
    private String type;
    private String operation;
    private String function;
    private double[] functionInputs;
    private int index;

    public EquationElement(String s) {

        this.type = this.getType(s);    // type shouldn't be null for this object, brackets only need type set

        if (this.type.equals(EquationPart.ELEMENT_TYPE_NUMBER.getString())) {
            this.value = Double.parseDouble(s);
        }
        else if (this.type.equals(EquationPart.ELEMENT_TYPE_OPERATOR.getString())) {
            this.operation = s;
        }
    }

    private String getType(String element) {

        if (EquationString.isOperator(element)) {
            return EquationPart.ELEMENT_TYPE_OPERATOR.getString();
        }
        else if (EquationString.isNumeric(element)) {
            return EquationPart.ELEMENT_TYPE_NUMBER.getString();
        }
        else if (EquationString.isOpeningBracket(element)) {
            return EquationPart.ELEMENT_TYPE_BRACKET_OPEN.getString();
        }
        else if (EquationString.isClosingBracket(element)) {
            return EquationPart.ELEMENT_TYPE_BRACKET_CLOSE.getString();
        }
        else if (EquationString.isFunction(element)) {
            return EquationPart.ELEMENT_TYPE_FUNCTION.getString();
        }

        System.err.println("Could not find type of equation element when constructing");
        return null;
    }

    public void setValue(String value) {
        this.value = Double.parseDouble(value);
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return this.value;
    }

    public String getType() {
        return this.type;
    }

    public String getOperation() {
        return this.operation;
    }

}
