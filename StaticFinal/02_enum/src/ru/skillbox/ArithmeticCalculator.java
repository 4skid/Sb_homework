package ru.skillbox;

public class ArithmeticCalculator {
    private final int a;
    private final int b;

    public ArithmeticCalculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void calculate (Operation type) {
        if (type != null) {
            switch (type) {
                case ADD -> System.out.println("Сумма чисел равна - " + (a + b));
                case SUBSTRACT -> System.out.println("Разность чисел равна - " + (a - b));
                case MULTIPLY -> System.out.println("Произведение чисел равно - " + (a * b));
                default -> System.out.println("Выберите операцию");
            }
        } else System.out.println("Такой команды нет");
    }
}
