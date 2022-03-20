package machinelearninggui;

import javax.swing.*;

public class CustomComponents {

    static JButton createButton(String text)
    {
        JButton button = new JButton(text);

        return button;
    }
    static JLabel createTitle(String text) {

        JLabel label = new JLabel(text);
        return label;
    }
}
