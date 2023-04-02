package ru.skillbox;

public class RAM {
    private final RAMType type;
    private final int amountOfRAM;
    private final int weight;

    public RAM(RAMType type, int amountOfRAM, int weight) {
        this.type = type;
        this.amountOfRAM = amountOfRAM;
        this.weight = weight;
    }

    public RAMType getType() {
        return type;
    }

    public int getAmountOfRAM() {
        return amountOfRAM;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Оперативная память\n" +
                "Тип: " + getType() +
                "\nОбъем: " + getAmountOfRAM() +
                "\nВес: " + getWeight();
    }
}
