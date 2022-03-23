package machinelearninggui;

//Swing library for GUI
import javax.swing.*;


//Array used to store the buttons to be displayed
import java.util.ArrayList;
import java.util.List;

//Custom components class is used to ensure consistency in design.
import static machinelearninggui.CustomComponents.*;

/**
 * This class operates as the view of the MVC Design pattern. It is used to present information to the user and
 * accepts user input which is passed to the controller.
 *
 * @author Jack O'Shea
 * @version 1.0
 * @since 20/03/2022
 */
public class View
{
    //Main Screen used for the Window.
    private final JFrame frame = new JFrame();

    //Panels used by the Window.
    private final JPanel mainScreen = createPanel();
    private final JPanel questionPanel = createPanel();
    private final JPanel resultScreen = createPanel();



    //Text used on mainScreen.
    private final JLabel mainTitle = createTitle("Naive Bayes Prediction Model");
    private final JLabel mainIntro = createLabel("Hello and Welcome to my Classifier");
    private final JLabel subIntro = createLabel("Please select the Dataset:");
    private final JLabel footerLabel = createLabel("Jack O'Shea 2022 - OOP ML Project");

    //Buttons used on mainScreen.
    private final JButton superhero = createButton("Superhero Dataset");
    private final JButton entrepreneur = createButton("Entrepreneur Dataset");



    //Title for the questionScreen.
    private final JLabel question = createTitle("");
    //Buttons for the questionScreen.
    private final List<JButton> buttons = new ArrayList<>();



    //Results Page Components:
    private final JLabel resultConcept = createTitle("");
    private final JLabel resultTitle = createTitle("The ML Prediction is");
    private final JLabel resultLabel = createTitle("");


    /**
     * <p>Begin View is a method called by the Controller to initialise the view.</p>
     */
    public void beginView()
    {
        //Call to setupFrame method which sets the size and title of the view.
        setupFrame();

        //Adds the introduction elements to the screen.
        beginMain();

    }

    /**
     * <p>Method which initialises the frame with the correct size, title and sets it to visible.</p>
     */
    public void setupFrame()
    {
        //Frame Information:
        frame.setTitle("Naive Bayes Algorithm");
        frame.setSize(960,540);
        frame.setVisible(true);
    }

    /**
     * <p>Method which initialises the first screen with all its UI elements and sets the layout type.</p>
     */
    public void beginMain()
    {
        //Removes all elements from the main screen.
        mainScreen.removeAll();


        //Main Screen setup:
        mainScreen.setLayout(new BoxLayout(mainScreen,BoxLayout.Y_AXIS));
        mainScreen.add(mainTitle);
        mainScreen.add(Box.createVerticalStrut(15));
        mainScreen.add(mainIntro);
        mainScreen.add(subIntro);
        mainScreen.add(Box.createVerticalStrut(150));
        mainScreen.add(entrepreneur);
        //Used to enable the superhero dataset.
        mainScreen.add(superhero);
        mainScreen.add(Box.createVerticalStrut(150));
        mainScreen.add(footerLabel);


        //Adds panel to main screen.
        getFrame().add(mainScreen);
    }

    /**
     * <p>Sets up a question panel with the questions </p>
     */
    public void setupQuestion()
    {
        //Constructs a question panel with the correct layout and a vertical strut for the buttons to be placed below.
        questionPanel.removeAll();
        questionPanel.setLayout(new BoxLayout(questionPanel,BoxLayout.Y_AXIS));
        questionPanel.add(question);
        questionPanel.add(Box.createVerticalStrut(175));

        //Removes the main screen if present, and adds the question screen.
        getFrame().remove(getMainScreen());
        getFrame().add(getQuestionPanel());
    }

    /**
     *<p>Sets up the results' page with the correct UI elements.</p>
     */
    public void setupResult()
    {

        //Result Screen
        resultScreen.setLayout(new BoxLayout(resultScreen,BoxLayout.Y_AXIS));
        resultScreen.add(resultConcept);
        resultScreen.add(resultTitle);
        resultScreen.add(Box.createVerticalStrut(125));
        resultScreen.add(resultLabel);

        getFrame().remove(getQuestionPanel());
        getFrame().add((getResultScreen()));

    }



    //GETTERS AND SETTERS.

    /**
     * <p>Returns the frame/window of the application</p>
     * @return the address of the Frame Object.
     */
    public JFrame getFrame()
    {
        return frame;
    }

    /**
     * <p>Returns the main screen of the application.</p>
     * @return the address of the mainScreen object.
     */
    public JPanel getMainScreen()
    {
        return mainScreen;
    }

    /**
     * <p>Gets the superhero button which is a secondary dataset.</p>
     * @return the address of the superhero button.
     */
    public JButton getSuperhero() {
        return superhero;
    }

    /**
     * <p>Gets the entrepreneur button which is the primary dataset.</p>
     * @return the address of the entrepreneur button.
     */
    public JButton getEntrepreneur() {
        return entrepreneur;
    }


    /**
     * <p>Gets the question panel which is used to modify elements by the controller.</p>
     * @return the address of the question panel.
     */
    public JPanel getQuestionPanel() {
        return questionPanel;
    }

    /**
     * <p>Gets the question label, so it can be modified by the controller.</p>
     * @return the address of the question label.
     */
    public JLabel getQuestion() {
        return question;
    }

    /**
     * <p>Gets all the button elements to be used for the question screen.</p>
     * @return the list of all buttons on the question screen.
     */
    public List<JButton> getButtons() {
        return buttons;
    }

    /**
     * <p>A setter function which adds a new button to the UI.</p>
     * @param button the button you wish to add, used by the controller.
     */
    public void addButton(JButton button) {
        this.buttons.add(button);
    }

    /**
     * <p>Returns the result screen which is modified by the controller.</p>
     * @return the address of the resultScreen.
     */
    public JPanel getResultScreen() {
        return resultScreen;
    }

    /**
     * <p>Returns the results label, so it can be modified by the controller.</p>
     * @return the address of the JLabel so it can be modified.
     */
    public JLabel getResultLabel() {
        return resultLabel;
    }

    /**
     * <p>The result concept label is used to modify the concept of the dataset on the UI.</p>mac
     * @return the address of the JLabel so it can be modified by the controller.
     */
    public JLabel getResultConcept()
    {
        return resultConcept;
    }










}
