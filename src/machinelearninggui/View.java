package machinelearninggui;

import javax.swing.*;

import static machinelearninggui.CustomComponents.createButton;
import static machinelearninggui.CustomComponents.createTitle;

public class View
{
    private JFrame frame = new JFrame();
    private JPanel mainScreen = new JPanel();
    private JPanel questionPanel = new JPanel();


    private JButton superhero = createButton("Superhero Dataset");
    private JButton entrepreneur = createButton("Entrepreneur Dataset");

    private JLabel question = createTitle("Lorem");



    private JButton choice1 = createButton("Lorem");



    private JButton choice2 = createButton("Lorem");
    public void beginView()
    {
        frame.setTitle("Naive Bayes Algorithm");
        frame.setSize(300,300);
        frame.setVisible(true);
        mainScreen.add(superhero);
        mainScreen.add(entrepreneur);

        questionPanel.add(question);
        questionPanel.add(choice1);
        questionPanel.add(choice2);


        frame.add(mainScreen);

    }


    public JFrame getFrame()
    {
        return frame;
    }
    public JPanel getMainScreen()
    {
        return mainScreen;
    }

    public JButton getSuperhero() {
        return superhero;
    }

    public JButton getEntrepreneur() {
        return entrepreneur;
    }

    public JPanel getQuestionPanel() {
        return questionPanel;
    }
    public JButton getChoice1() {
        return choice1;
    }

    public JLabel getQuestion() {
        return question;
    }

    public JButton getChoice2() {
        return choice2;
    }

    public void reset()
    {
        frame.setVisible(false);
        frame.setVisible(true);

    }







}
