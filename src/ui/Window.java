package ui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        super("Snake");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel emptyLabel = new JLabel();
        emptyLabel.setPreferredSize(new Dimension(500,400));
        super.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        super.pack();
        super.setVisible(true);
    }
}
