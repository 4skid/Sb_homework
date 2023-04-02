package ru.skillbox;

public class Book {
    private final String name;
    private final String author;
    private final int pagesCount;
    private final int ISBN;

    public Book(String name, String author, int pagesCount, int ISBN) {
        this.name = name;
        this.author = author;
        this.pagesCount = pagesCount;
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public int getISBN() {
        return ISBN;
    }

    public void print() {
        System.out.println("Название книги: " + name + " Автор: " + author
                + " Количесвто страниц: " + pagesCount + " ISBN: " + ISBN);
    }
}
