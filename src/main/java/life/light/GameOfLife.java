package life.light;

import javax.swing.*;

public class GameOfLife {
    public static void main(String[] args) {

        int size = 90;

        //Display / Affichage
        JFrame windows = new JFrame();
        windows.setContentPane(new Frame());

        //Sets a window title / Définit un titre de la fenêtre
        windows.setTitle("Game of life / Le jeu de la vie");
        //Sets the window size / Définit la taille de la fenêtre
        windows.setSize(size*10+20, size*10+40);
        //Position the window in the center / Positionne la fenêtre au centre
        windows.setLocationRelativeTo(null);
        //Ends the process when the red cross is clicked / Termine le processus lorsqu'on clique sur la croix rouge
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Make the window visible / Rendre visible la fenêtre
        windows.setVisible(true);
        Frame pane = new Frame();
        windows.setContentPane(pane);
    }
}