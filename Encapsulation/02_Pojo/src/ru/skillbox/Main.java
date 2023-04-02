package ru.skillbox;

public class Main {

    public static void main(String[] args) {
       Rice rice1 = new Rice("Янтарь",1.21);
       Rice rice2 = new Rice("Антарика", 1.05);
       Rice rice3 = new Rice("Ориент", 0.8);
       rice1.print();
       rice2.print();
       rice3.print();

       Country country = new Country("Россия");
       country.print();


    }
}
