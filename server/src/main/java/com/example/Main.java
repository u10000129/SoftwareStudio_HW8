package com.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Server obj = new Server(frame);
    }
}
