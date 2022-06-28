package com.jeu;

import javax.swing.*;

public class Main {

    public static JFrame window;
    public static Scene scene;
    public static void main(String[] args) {
        window = new JFrame("Flappy bird");
        scene = new Scene();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(300, 425);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setAlwaysOnTop(true);

        window.setContentPane(scene);
        window.setVisible(true);
    }
}
