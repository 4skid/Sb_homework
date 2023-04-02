package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Product product = new Product("Банан",2346872);
        product.print();

        Book book  = new Book("Дюймовочка", "Андерсон", 125,97850010);
        book.print();
    }
}
