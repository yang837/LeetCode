package exp13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyJDiolog extends JDialog {

    public MyJDiolog(MyFrame frame) {
        super(frame, "aaa", true);
        Container container = getContentPane();
        container.add(new Label("bbb"));
        setBounds(120, 120, 100, 100);
    }
}

public class MyFrame extends JFrame {
    public static void main(String[] args) {
        new MyFrame();
    }

    public MyFrame() {
        JFrame frame = new JFrame();
        Container container = frame.getContentPane();
        container.setLayout(null);

        JButton button = new JButton("button1");
        button.setBounds(10, 10, 100, 21);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyJDiolog(MyFrame.this).setVisible(true);
            }
        });
        container.add(button);

        frame.setVisible(true);
        frame.setBackground(Color.WHITE);
        frame.setSize(550, 250);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
