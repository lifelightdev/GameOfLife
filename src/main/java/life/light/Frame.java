package life.light;

import javax.swing.JPanel;
import java.awt.*;

public class Frame extends JPanel {
    public void paintComponent(Graphics g){
        //We choose a background color for the rectangle / On choisit une couleur de fond pour le rectangle
        g.setColor(Color.white);
        //We draw it so that it occupies the entire surface / On le dessine de sorte qu'il occupe toute la surface
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);
    }
}
