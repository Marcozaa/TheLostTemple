package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("The lost temple");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gamePanel.startGameThread();

    }
}
