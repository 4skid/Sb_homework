package ru.skillbox;

public class Drive {
    private final DriveType type;
    private final int amountOfRam;
    private final int weight;

    public Drive(DriveType type, int amountOfRam, int weight) {
        this.type = type;
        this.amountOfRam = amountOfRam;
        this.weight = weight;
    }

    public DriveType getType() {
        return type;
    }

    public int getAmountOfRam() {
        return amountOfRam;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Накопитель информации\n" +
                "Тип памяти: " + getType() +
                "\nОбъем памяти: " + getAmountOfRam() +
                "\nВес: " + getWeight();
    }
}
