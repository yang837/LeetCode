package exp13;

import javax.swing.*;
import java.awt.*;

public class Example1 extends JFrame {
    public void CreateJFrame(String title) {
        Container container = getContentPane();
        JLabel label = new JLabel("this is a label");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        container.add(label);

        setTitle(title);
        setBackground(Color.white);
        setVisible(true);
        setSize(750, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Example1().CreateJFrame("frame");
    }
}
