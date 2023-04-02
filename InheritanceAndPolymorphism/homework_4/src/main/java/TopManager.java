public class TopManager implements Employee {
    private static final int FIX_SALARY = 70000;
    private static final int INCREASE_SALARY_DEMAND = 10_000_000;
    private static final double INCREASE_SALARY_COEF = 1.5;
    private Company company;

    protected TopManager(Company company) {
        setCompany(company);
    }

    @Override
    public int getMonthSalary() {
        int salary;
        if (company.getIncome() >= INCREASE_SALARY_DEMAND) {
            salary = FIX_SALARY + (int) (FIX_SALARY * INCREASE_SALARY_COEF);
            return salary;
        } else {
            return FIX_SALARY;
        }
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }
}
