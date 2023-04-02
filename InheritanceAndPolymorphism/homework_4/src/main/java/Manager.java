public class Manager implements Employee {
    private static final int MAX_SALES = 140000;
    private static final int MIN_SALES = 115000;
    private static final int FIX_SALARY = 30000;
    private static final double SALES_PERCENT = 0.05;
    int sales = (int) ((Math.random() * (MAX_SALES - MIN_SALES)) + MIN_SALES);

    protected int getSales() {
        return sales;
    }

    @Override
    public int getMonthSalary() {
        return FIX_SALARY + (int) (sales * SALES_PERCENT);
    }
}
