public abstract class Client {

    private double moneyAmount;

    public double getAmount() {
        return moneyAmount;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            moneyAmount = moneyAmount + amountToPut;
            System.out.println("Баланс пополнен на " + amountToPut);
            System.out.println("Баланс: " + moneyAmount);
        } else {
            moneyAmount = moneyAmount + 0;
            System.out.println("Баланс не изменился");
        }
    }

    public void take(double amountToTake) {
        if (amountToTake <= moneyAmount){
            moneyAmount = moneyAmount - amountToTake;
            System.out.println("Снятие со счета " + amountToTake);
            System.out.println("Баланс: " + moneyAmount);
        } else {
            moneyAmount = moneyAmount - 0;
            System.out.println("Баланс не изменился");
        }
    }

}
