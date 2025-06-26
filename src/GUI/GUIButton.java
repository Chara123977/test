package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIButton extends JButton {
    public GUIButton(String text) {
        super(text);
        setBackground(Color.DARK_GRAY);
        setForeground(Color.MAGENTA);
        setFont(new Font("Serif", Font.BOLD, 24));
    }
}
