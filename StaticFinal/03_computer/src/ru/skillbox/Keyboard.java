package ru.skillbox;

public class Keyboard {
    private final KeyboardType type;
    private final boolean backlight;
    private final int weight;


    public Keyboard(KeyboardType type, boolean backlight, int weight) {
        this.type = type;
        this.backlight = backlight;
        this.weight = weight;
    }

    public KeyboardType getType() {
        return type;
    }

    public boolean isBacklight() {
        return backlight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Клавиатура\n" +
                "Тип клавиатуры: " + getType() +
                "\nНаличие подсветки: " + isBacklight() +
                "\nВес: " + getWeight();
    }
}
