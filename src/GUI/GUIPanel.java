package GUI;

import javax.swing.*;
import java.awt.*;
import Calculate.*;

public class GUIPanel extends JPanel {
    static final String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
    };
    public GUIPanel() {
        setLayout(new BorderLayout());
        DisplayField DF = new DisplayField();
        add(DF, BorderLayout.NORTH);
        add(new ButtonPanel(DF), BorderLayout.CENTER);
    }
    public class ButtonPanel extends JPanel {
        public ButtonPanel(DisplayField DF) {
            setLayout(new GridLayout(4, 4, 10, 10));
            setBackground(Color.LIGHT_GRAY);
            for (String label : buttonLabels) {
                JButton button = new GUIButton(label);
                add(button);
                button.addActionListener(e -> {
                    if (label.equals("=")) {
                        DF.Reset = true;
                        try {
                            Calculator.GetText(DF);
                        } catch (Exception ex) {
                            DF.setText("Error: "+ex.getMessage());
                            ex.printStackTrace();
                        }
                        return;
                    }
                    if (DF.Reset) {
                        DF.Reset = false;
                        DF.setText("");
                    }
                    DF.setText(DF.getText() + ((GUIButton) e.getSource()).getLabel());
                });
            }
        }
    }
    public class DisplayField extends JTextArea {
        public Boolean Reset = false;
        public DisplayField() {
            setColumns(20);
            setRows(2);
            setEditable(false);
            setFont(new Font("Serif", Font.BOLD, 24));
            setLineWrap(true);
            setWrapStyleWord(true);
            JScrollPane scrollPane = new JScrollPane(this);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setBorder(BorderFactory.createEmptyBorder());
        }
    }
}
