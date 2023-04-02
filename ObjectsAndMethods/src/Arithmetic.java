
public class Arithmetic {
    private final int value1;
    private final int value2;

    public Arithmetic(int value1, int value2) {
        this.value1 =value1;
        this.value2 =value2;
        System.out.println();
        System.out.println("Вычисляем значение чисел для чисел: " + value1 + " и " + value2);
        sum();
        multiply();
        maxOfValues();
        minOfValues();
    }

    public void sum() {
        int sum = value1 + value2;
        System.out.println("Сумма чисел: " + sum);
        return;
    }
    public void multiply() {
        int multiply = value1 * value2;
        System.out.println("Произведение чисел: " + multiply);
        return;
    }
    public void maxOfValues() {
        int maxOfValues = Math.max(value1,value2);
        System.out.println("Максимальное из двух чисел: " + maxOfValues);
        return;
    }
    public void minOfValues() {
        int minOfValues = Math.min(value1,value2);
        System.out.println("Минимальное из двух чисел: " + minOfValues);
        return;
    }
}
