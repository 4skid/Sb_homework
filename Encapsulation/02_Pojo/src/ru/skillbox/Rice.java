package ru.skillbox;

public class Rice {
    private String name; // сорт риса
    private double lenght; // длина зерна риса
    private String color; // цвет зерна
    private double cookingTime; // время варки

    public Rice(String name, double lenght) {
        this.name = name;
        this.lenght = lenght;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(double cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void print(){
        System.out.println(getName() + " - "+ getLenght());

    }
}

