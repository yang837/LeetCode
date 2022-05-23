package exp13;

import javax.swing.*;
import java.awt.*;

public class AbsolutePosition extends JFrame {
    public AbsolutePosition() {
        setTitle("Absolute Position");
        setLayout(null);
        setBounds(0, 0, 250, 150);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();

        JButton button1 = new JButton("a");
        JButton button2 = new JButton("b");

        button1.setBounds(10, 30, 80, 30);
        button2.setBounds(60, 70, 80, 30);

        container.add(button1);
        container.add(button2);
    }

    public static void main(String[] args) {
        new AbsolutePosition();
    }
}
