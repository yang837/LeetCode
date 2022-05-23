package exp13;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MyImageIcon extends JFrame {
    public MyImageIcon() {
        Container container = getContentPane();

        URL url = MyImageIcon.class.getResource("image.png");
        Icon icon = new ImageIcon(url);

        JLabel label = new JLabel("aa", icon, JLabel.CENTER);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        container.add(label);
        setSize(250, 100);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyImageIcon();
    }

}
