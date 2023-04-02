package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator(25,17);
        calculator.calculate(Operation.ADD);
        calculator.calculate(Operation.MULTIPLY);
        calculator.calculate(Operation.SUBSTRACT);
        calculator.calculate(null);
    }
}
