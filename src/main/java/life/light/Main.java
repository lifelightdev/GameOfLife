package life.light;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setContentPane(new ThePanel());

        window.setTitle("Game of life / Le jeu de la vie");
        int sizeOfWorld = 90;
        window.setSize(sizeOfWorld*10+20, sizeOfWorld*10+40);
        // in center
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        ThePanel pan = new ThePanel();
        window.setContentPane(pan);
    }
}