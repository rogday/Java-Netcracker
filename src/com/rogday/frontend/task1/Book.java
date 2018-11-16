package com.rogday.frontend.task1;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
    private String title;
    private ArrayList<String> authors;
    private int price;

    public Book(String title, ArrayList<String> authors, int price) {
        this.title = title;
        this.authors = authors;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Book{title=%s, authors=%s, price=%d}",
                title, authors.toString(), price);
    }
}
