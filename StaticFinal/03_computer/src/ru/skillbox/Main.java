package ru.skillbox;

public class Main {

    public static void main(String[] args) {
    Computer computer = new Computer("HP", "Pavilion");
        System.out.println(computer);
        computer.setDrive(new Drive(DriveType.HDD,2000,412));
        System.out.println("\n---------------\n" + computer);
        System.out.println("\nТип оперативноый памяти: " + computer.getRam().getType());
        computer.setProcessor(new Processor(9999,99,"AMD",30));
        System.out.println(computer.getProcessor());
    }
}
