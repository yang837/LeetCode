package exp13;

import javax.swing.*;
import java.awt.*;

public class DrawIcon implements Icon{
    private int width;
    private int height;

    public DrawIcon(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x, y, width, height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }

    public static void main(String[] args) {
        DrawIcon icon = new DrawIcon(15, 15);
        JLabel label = new JLabel("aa", icon, SwingConstants.CENTER);

        JFrame frame = new JFrame();
        Container container = frame.getContentPane();
        container.add(label);

        frame.setSize(250, 150);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
