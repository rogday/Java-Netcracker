package com.rogday;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var circle = new Circle(42.0, "yellow");
        System.out.println(circle);
        System.out.println(circle.getArea());

        var rectangle = new Rectangle(6.0f, 7.0f);
        System.out.println(rectangle);
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimetr());

        var employee = new Employee(42, "Amelia", "Pond", 1337);
        System.out.println(employee);
        System.out.println(employee.getName());
        employee.raiseSalary(50);
        System.out.println(employee.getAnnualSalary());

        Author[] authors = {new Author("Stephen King", "stephen_king@ya.ru", 'm'),
                new Author("Another Author", "IDontReadBooks@shameOn.Me", 'f')};
        var book = new Book("Original name for a book", authors, 100500, 228);
        System.out.println(book);
        System.out.println(book.getAuthorNames());

        var mypoint = new MyPoint(3, 4);
        System.out.println(mypoint);
        System.out.println(mypoint.distance());
        System.out.println(Arrays.toString(mypoint.getXY()));

        var mytriangle = new MyTriangle(0, 0, 1, 0, 1, 1);
        System.out.println(mytriangle);
        System.out.println(mytriangle.getPerimetr());
        System.out.println(mytriangle.getType());
    }
}
