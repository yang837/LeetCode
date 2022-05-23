package exp13;

import javax.swing.*;
import java.awt.*;

public class CheckBoxTest extends JFrame {
    public CheckBoxTest() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        Panel panel1 = new Panel();
        container.add(panel1, BorderLayout.NORTH);

        JTextArea jTextArea = new JTextArea();

        final JScrollPane scrollPane = new JScrollPane(jTextArea);
        container.add(scrollPane);

        setVisible(true);
        setSize(500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new CheckBoxTest();
    }
}
