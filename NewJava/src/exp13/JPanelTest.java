package exp13;

import javax.swing.*;
import java.awt.*;

public class JPanelTest extends JFrame {
    public JPanelTest() {
        Container container = getContentPane();
        container.setLayout(new GridLayout(3, 1, 10, 10));

        JPanel p1 = new JPanel(new GridLayout(1, 3, 10, 10));
        JPanel p2 = new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel p3 = new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel p4 = new JPanel(new GridLayout(2, 1, 10, 10));

        JScrollPane scrollPane = new JScrollPane(new JTextArea(20, 20));

        p1.add(new JButton("1"));
        p1.add(new JButton("1.1"));
        p1.add(new JButton("1.2"));
        p2.add(new JButton("2"));
        p2.add(new JButton("2.1"));
        p3.add(new JButton("3"));
        p3.add(new JButton("3.1"));
        p4.add(new JButton("4"));
        p4.add(new JButton("4.1"));

        container.add(p1);
        container.add(p2);
        container.add(p3);
        container.add(p4);
        container.add(scrollPane);

        setSize(450, 350);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JPanelTest();
    }
}
