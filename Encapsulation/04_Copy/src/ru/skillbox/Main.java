package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        Dimensions dimensions = new Dimensions(2,9,3);
        CargoInfo cargoInfo = new CargoInfo(
                dimensions.getVolume(),
                2,
                "sdf",
                true,
                "sdf3s",
                true);
        System.out.println(cargoInfo);
        System.out.println();
        System.out.println(cargoInfo.setAdress("ул. Полевая"));
        System.out.println();
        System.out.println(cargoInfo.setMultyDimensions(24));
        System.out.println();
        System.out.println(cargoInfo.setWeight(11));

    }
}
