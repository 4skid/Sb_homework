package ru.skillbox;

public class Processor {
    private final int frequency;
    private final int numberOfCores;
    private final String manufacturer;
    private final int weight;

    public Processor(int frequency, int numberOfCores, String manufacturer, int weight) {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Процессор\n" +
                "Частота процессора: " + getFrequency() +
                "\nКоличество ядер: " + getNumberOfCores() +
                "\nПроизводтель: " + getManufacturer() +
                "\nВес: " + getWeight();
    }
}
