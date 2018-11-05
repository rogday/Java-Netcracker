package com.rogday;

import java.util.Arrays;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty;

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors.clone();
        this.price = price;
        this.qty = qty;
    }

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors.clone();
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors.clone();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String toString() {
        return String.format("Book[name=%s,authors=%s,price=%f, qty=%d]",
                name, Arrays.toString(authors), price, qty);
    }

    public String getAuthorNames() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < authors.length - 1; ++i)
            builder.append(authors[i].getName()).append(", ");
        builder.append(authors[authors.length - 1].getName());

        return builder.toString();
    }
}
