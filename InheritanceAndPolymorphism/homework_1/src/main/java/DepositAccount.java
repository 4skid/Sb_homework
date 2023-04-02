import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    private LocalDate lastIncome;

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
        lastIncome = LocalDate.now();

    }

    @Override
    public void take(double amountToTake) {
        LocalDate dateCanTake = lastIncome.plusMonths(1);
        if (LocalDate.now().isAfter(dateCanTake)){
            super.take(amountToTake);
        } else {
            System.out.println("Нельзя снимать деньги в течение одного месяца после последнего пополнения");
        }
    }
}
