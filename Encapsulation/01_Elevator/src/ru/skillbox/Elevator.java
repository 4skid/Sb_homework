package ru.skillbox;

public class Elevator {

    private int currentFloor = 1;
    private final int minFloor;
    private final int maxFloor;

    public Elevator (int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown () {
        currentFloor = currentFloor - 1;
    }

    public void moveUp() {
        currentFloor = currentFloor + 1;
    }

    public void printCurrentFloor () {
        System.out.println("Лифт на " + getCurrentFloor() + " этаже");
    }


    public void move(int floor) {
        if (minFloor <= floor && floor <= maxFloor){
            while (currentFloor < floor){
                printCurrentFloor();
                moveUp();
            }
            while (currentFloor > floor) {
                printCurrentFloor();
                moveDown();
            }
            if (currentFloor == floor) {
                System.out.println("Лифт на " + currentFloor + " этаже");
            }
        } else {
            System.out.println("Такого этажа нет, введите верный этаж!");
        }
    }
}
