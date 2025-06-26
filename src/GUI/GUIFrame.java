package GUI;

import javax.swing.*;

public class GUIFrame extends JFrame {
    public GUIFrame() {
        setTitle("My Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(400,500);
        add(new GUIPanel());
    }
}
