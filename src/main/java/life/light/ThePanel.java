package life.light;

import javax.swing.*;
import java.awt.*;

public class ThePanel extends JPanel {

    public void paintComponent(Graphics g){
        //get color
        g.setColor(Color.white);
        //all windows
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);
    }

}
