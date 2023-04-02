import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {

    private final List<Employee> employeeList = new ArrayList<>();

    protected List<Employee> getEmployeeList() {
        return new ArrayList<>(employeeList);
    }

    public void hire(Employee employee) {
        employee.setCompany(this);
        employeeList.add(employee);
    }

    public void hireAll(List<Employee> list) {
        employeeList.addAll(list);
    }

    public void fire(Employee employee) {
        employee.setCompany(null);
        employeeList.remove(employee);
    }

    protected int getIncome() {
        int income = 0;
        for (Employee employee : employeeList) {
            if (employee instanceof Manager) {
                income += ((Manager) employee).getSales();
            }
        }
        return income;
    }

    protected List<Employee> getList(int count, Comparator<Employee> comparator) {
        if (count < 0) {
            return Collections.emptyList();
        }
        if (count > employeeList.size()) {
            count = employeeList.size();
        }
        employeeList.sort(comparator);
        return new ArrayList<>(employeeList.subList(0, count));
    }

    protected List<Employee> getTopSalaryStaff(int count) {
        return getList(count, Comparator.reverseOrder());
    }

    protected List<Employee> getLowestSalaryStaff(int count) {
        return getList(count, Comparator.naturalOrder());
    }
}
