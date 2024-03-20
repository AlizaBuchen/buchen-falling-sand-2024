package buchen.fallingsand;

import javax.swing.JComponent;
import java.awt.*;


public class SandComponent extends JComponent {

    private final Sand sand;

    public SandComponent(Sand sand) {
        this.sand = sand;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);




        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                if (sand.get(x, y) == 1) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x*2, y, 10, 10);
                }
            }
        }
        sand.fall();
        repaint();
    }
}
