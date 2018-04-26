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

// 1. scan for brackets, find brackets '(' then end at next ')' solve the extracted brackets
// 2. solve (recursive down a level) if another opening '(' is in this it will run solve recursively until no more brackets
// 3. return if all elements computed and no brackets in expression (return with new set of elements replacing brackets with calculated value), back up the chain
// 4. return solve(total)

// test on this string input: 1+sine(2+3+cf(1+2,3,4))*10    where cf is a custom function a*b*c+5
//              fn processed: 1+sine(2+3+(1+2)*(3)*(4)+5)*10
//                          : insert commas
//              start solver
//                    step 1: convert all brackets to numbers, scan for brackets
//                    step 2: solver extracts sine's bracket [ 2+3+(1+2)*(3)*(4)+5 ]
//                    step 3: solves bracket 1 (1+2)
//                    step 4: then solves bracket 2,3
//                    step 5: solved sine's bracket now string looks like 1+sine(41)*10 or 1,+,sine,41,*,10