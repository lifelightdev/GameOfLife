package life.light;

import javax.swing.*;
import java.util.HashSet;
import java.util.Random;

public class GameOfLife {
    public static void main(String[] args) {

        int size = 90;
        World world = new World(size, initWorld(size));

        //Display / Affichage
        JFrame window = new JFrame();
        window.setContentPane(new Frame());

        //Sets a window title / Définit un titre de la fenêtre
        window.setTitle("Game of life / Le jeu de la vie");
        //Sets the window size / Définit la taille de la fenêtre
        window.setSize(size * 10 + 20, size * 10 + 40);
        //Position the window in the center / Positionne la fenêtre au centre
        window.setLocationRelativeTo(null);
        //Ends the process when the red cross is clicked / Termine le processus lorsqu'on clique sur la croix rouge
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Make the window visible / Rendre visible la fenêtre
        window.setVisible(true);
        Frame pane = new Frame();
        window.setContentPane(pane);

        for (int generationNumber = 0; generationNumber < 10000; generationNumber++) {
            pane.setWorld(world);
            pane.revalidate();
            pane.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            world = new World(size, world.nextGeneration());
        }
    }

    public static HashSet<Cell> initWorld(int size) {
        Random rand = new Random();
        int numberOfLivingCellsBeingCreated = 0;
        int numberOfLivingCellsToCreate = size * (100 / 3);
        HashSet<Cell> cellsAliveInTheWorld = new HashSet<>();
        while (numberOfLivingCellsBeingCreated < numberOfLivingCellsToCreate) {
            Cell cell = new Cell(rand.nextInt(size), rand.nextInt(size));
            cellsAliveInTheWorld.add(cell);
            numberOfLivingCellsBeingCreated++;
        }
        return cellsAliveInTheWorld;
    }
}