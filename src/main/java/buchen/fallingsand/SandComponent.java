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

        sand.fall();
        repaint();

        for (int y = 0; y < sand.getHeight(); y++) {
            for (int x = 0; x < sand.getWidth(); x++) {
                if (sand.get(x, y) == 1) {
                    g.setColor(Color.PINK);
                    g.fillRect(x * 2, y, 2, 2);
                }
            }
        }
    }
}
