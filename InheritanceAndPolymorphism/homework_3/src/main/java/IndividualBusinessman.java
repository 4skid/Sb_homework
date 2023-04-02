public class IndividualBusinessman extends Client {
    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void put(double amountToPut) {
        if (amountToPut < 1000) {
            super.put(amountToPut * 0.99);
        } else if (amountToPut >= 1000){
            super.put(amountToPut * 0.995);
        }
    }

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake);
    }
}
