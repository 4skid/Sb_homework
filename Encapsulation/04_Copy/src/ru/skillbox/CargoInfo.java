package ru.skillbox;

public class CargoInfo {
    private final int multyDimensions;
    private final int weight;
    private final String adress;
    private final boolean rotate;
    private final String regnumber;
    private final boolean fragile;

    public CargoInfo(int multyDimensions ,int weight, String adress, boolean rotate,
                     String regnumber, boolean fragile) {
        this.multyDimensions = multyDimensions;
        this.weight = weight;
        this.adress = adress;
        this.rotate = rotate;
        this.regnumber = regnumber;
        this.fragile = fragile;
    }

    public CargoInfo() {
        multyDimensions = 0;
        weight = 0;
        adress = "na";
        rotate = true;
        regnumber = "na";
        fragile = true;
    }

    public CargoInfo setAdress(String adress) {
        return new CargoInfo(multyDimensions, weight, adress, rotate, regnumber, fragile);
    }

    public CargoInfo setMultyDimensions (int multyDimensions)  {
        return new CargoInfo(multyDimensions, weight, adress, rotate, regnumber, fragile);
    }

    public CargoInfo setWeight(int weight) {
        return new CargoInfo(multyDimensions, weight, adress, rotate, regnumber, fragile);
    }

    public int getMultyDimensions() {
        return multyDimensions;
    }

    public int getWeight() {
        return weight;
    }

    public String getAdress() {
        return adress;
    }

    public boolean isRotate() {
        return rotate;
    }

    public String getRegnumber() {
        return regnumber;
    }

    public boolean isFragile() {
        return fragile;
    }

    public String toString() {
        return "Объем груза - " + multyDimensions + "\n" +
                "Вес - " + weight + "\n" +
                "Адрес - " + adress + "\n" +
                "Можно ли переворачивать - " + rotate + "\n" +
                "Регистрационный номер - " + regnumber + "\n" +
                "Хрупкий груз - " + fragile;
    }
}
