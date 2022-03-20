package machinelearninggui;

//Import swing library for UI elements.
import javax.swing.*;
import java.awt.*;

/**
 * This class is a helper class used to create UI elements with customised styling and centering to avoid having to
 * style each individual element.
 *
 * @author Jack O'Shea
 * @version 1.0
 * @since 20/03/2022
 */
public class CustomComponents {
    //FONTS:
    /**
     * Font used for the title.
     */
    private static final Font titleFont = new Font("Sans-Serif",Font.BOLD,32);
    /**
     * Font used for everything else in the program.
     */
    private static final Font mainFont = new Font("Sans-Serif",Font.PLAIN,24);


    //COLOURS:
    /**
     * Main Background color is a dark gray.
     */
    private static final Color mainColour = Color.DARK_GRAY;
    /**
     * The colour of the title is white.
     */
    private static final Color titleColour = Color.white;
    /**
     * The button background is white.
     */
    private static final Color mainButtonBackground = Color.white;
    /**
     * The button text colour is black.
     */
    private static final Color mainButtonForeground = Color.black;


    /**
     * <p>This method creates a button with customised styling.</p>
     * @param text the text used as a label for the button.
     * @return a JButton object to be used in the view.
     */
    static JButton createButton(String text)
    {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setOpaque(true);
        button.setBackground(mainButtonBackground);
        button.setForeground(mainButtonForeground);
        button.setFont(mainFont);
        return button;
    }

    /**
     * <p>This method creates a title with customised styling</p>
     * @param text the text used for the label.
     * @return a JLabel object with customised styling to be used in the view.
     */
    static JLabel createTitle(String text) {

        JLabel label = new JLabel(text);
        label.setFont(titleFont);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(titleColour);
        return label;
    }

    /**
     * <p>Creates a new Panel with the background color already set with the option of adding more styling.</p>
     * @return a JPanel object with the background color set.
     */
    static JPanel createPanel()
    {
        JPanel panel = new JPanel();
        panel.setBackground(mainColour);
        return panel;
    }

    /**
     * <p>Creates a new Label with the styling and centering already implemented.</p>
     * @param text the text used for the label.
     * @return a JLabel object with the styling already done.
     */
    static JLabel createLabel(String text)
    {
        JLabel label = new JLabel(text);
        label.setFont(mainFont);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(titleColour);
        return label;
    }

}
