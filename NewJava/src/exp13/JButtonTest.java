package exp13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class JButtonTest extends JFrame {
    public JButtonTest() {
        URL url = JButtonTest.class.getResource("image.png");
        Icon icon = new ImageIcon(url);

        setLayout(new GridLayout(3, 2, 10, 10));

        Container container = getContentPane();

        for (int i = 0; i < 5; i++) {
            JButton button = new JButton("button" + i, icon);
            container.add(button);
            if (i % 2 == 0) {
                button.setEnabled(false);
            }
        }

        JButton button = new JButton();
//        button.setMaximumSize(new Dimension(15, 15));
        button.setIcon(icon);
        button.setHideActionText(true);
        button.setToolTipText("222");
        button.setBorderPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "aaa");
            }
        });

        container.add(button);

        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonTest();
    }
}
