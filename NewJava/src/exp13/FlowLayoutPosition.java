package exp13;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutPosition extends JFrame {
    public FlowLayoutPosition() {
//        setLayout(new FlowLayout(1, 10, 10));
        setLayout(new GridLayout(5, 5, 10, 10));
        Container container = getContentPane();

        for (int i = 0; i < 24; i++) {
            container.add(new JButton("button" + i));
        }
//        container.add(BorderLayout.NORTH, new JButton("11"));

        setTitle("FlowLayout");
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FlowLayoutPosition();
    }
}
