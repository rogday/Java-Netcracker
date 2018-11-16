package com.rogday.frontend.task1;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MyGUI extends JFrame {
    public MyGUI() {
        super("MyGUI Window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new MyGUI());
        var array = BookGenerator.generate(10);
        System.out.println(array);

        try {
            FileOutputStream fos = new FileOutputStream("data\\book");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(array);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
