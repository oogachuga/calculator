package com.calculator;

public class Calculator {

    private EquationElements equation;

    public double solve(EquationElements equation) {

        this.equation = equation;
        this.printDebug();

        return 0;
    }

    private void printDebug() {
        for (EquationElement element: this.equation.getElements()) {
            System.out.println(element.getType() + ", " + element.getValue() + ", " + element.getOperation());
        }
    }

}

// 20 +2 - 4 + (1 * 2 + 3 * ( 2 + 2) ) + 3^2/2 + (1 + 2) + sin(2)
// 20,+,2,-,4,+,(,1,*,2,+,3,*,(,2,+,2,),),+,3,^,2,/,2,+,(,1,+,2,)
// 20,+,2,-,4,+,(,1,*,2,+,3,*,(,2,+,2,),),+,[3^(2+2*sin(2))],/,2,+,(,1,+,2,)+[sin(2+2+2+2)]
// 20,+,2,-,4,+,(,1,*,2,+,3,*,(,2,+,2,),),+,[pow(3, 2+2*sin(2))],/,2,+,(,1,+,2,)+[sin(2+2+2+2)]
// require a function solver, if function solve each parameter ....
// invalid 01 + 2 + 0002, valid: .01, 0.01

// 20 + 2 - 4 + (1 * 2 + 3 * (2 + 2) ) + 3^2/2 + (1 + 2)
// 1. scan for brackets, find brackets '(' then end at next ')' solve the extracted brackets
// 2. solve (recursive down a level) if another opening '(' is in this it will run solve recursively until no more brackets
// 3. return if all elements computed and no brackets in expression (return with new set of elements replacing bracket with calculated value), back up the chain
// 4. return solve(total)

// bracket extractor
// hasBracket.....  1 + 1 + 1 + ( 1 + 2 + ( 2 + ( 2 + 2 ) ) - 2 + ( 3 + 3 ) ) + 1
// find closing bracket, if next char == open, lock++ else lock--,
