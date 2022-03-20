package machinelearninggui;

//Libraries for GUI and action listeners for buttons.
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Personal library to create button with custom styling.
import static machinelearninggui.CustomComponents.createButton;


/**
 * This class operates as the controller of the MVC Design pattern, it is used to read information from the model
 * and modify the view.
 *
 * @author Jack O'Shea
 * @version 1.0
 * @since 20/03/2022
 */
public class Controller implements ActionListener
{
    /**
     * The view which the controller is modifying.
     */
    private final View view;
    /**
     * The model which the data is being read from and written to.
     */
    private final Model model;


    /**
     * Constructor which creates a controller object.
     * @param view the UI of the program which is modified by this controller.
     * @param model the data of this program which is read from and written to by this controller.
     */
    public Controller(View view, Model model)
    {
            //Save view and model as variables.
            this.view = view;
            this.model = model;

            //Begin the view on the first page.
            this.view.beginView();

            //Add action listeners to the buttons.
            this.view.getEntrepreneur().addActionListener(this);
            this.view.getSuperhero().addActionListener(this);

    }

    /**
     * This method initialises the question screen, sets the text of the question, and creates the buttons.
     */
    public void getQuestion()
    {
        //Restart the screen.
        view.setupQuestion();

        //Set the question text.
        view.getQuestion().setText(model.getFeature());

        //Removes all buttons from the list
        view.getButtons().clear();


        //For each user choice create a new button.
        for(String choice: model.getChoices())
        {
            view.addButton(createButton(choice));
        }

        //Add action listeners to the buttons and place them on the panel.
        for(JButton button : view.getButtons())
        {
            button.addActionListener(this);
            view.getQuestionPanel().add(button);
            view.getQuestionPanel().add(Box.createVerticalStrut(15));


        }

        //Reset the view to update new buttons.
        view.getFrame().revalidate();
        view.getFrame().repaint();

    }

    /**
     * Displays the final value and outputs it to terminal for error testing.
     */
    public void displayResult()
    {
        //Set up the view with new screen.
        view.setupResult();

        //Print result to stdout
        System.out.println("Model Prediction using Naive Bayes: " + model.getResult());


        //Updates the UI elements.
        view.getResultConcept().setText(model.getConcept());
        view.getResultLabel().setText(model.getResult());

    }

    /**
     * Action listener which checks for button presses and performs actions based on the source.
     * @param e an action event, IE a button press.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //If the button presses is called Entrepreneur.
        if (view.getEntrepreneur().equals(e.getSource())) {
            //Print to STD output
            System.out.println("Entrepreneur dataset was chosen.");

            //Set the correct dataset
            model.setFilename("MLData.csv");
            //Set the concept of the dataset
            model.setConcept("Will this person become an entrepreneur?");

            //Begin the setup to initialise the screen.
            view.setupQuestion();
            //Gets the next question
            getQuestion();
        }

        //Commented out, accesses secondary database.
        /*
        else if(view.getSuperhero().equals(e.getSource()))

        {
            System.out.println("Superhero dataset was chosen.");
            dataset = "Superhero";
            model.setFilename("superhero.csv");
            getQuestion();
        }
        */
        else
        {   //If an action event occurs otherwise, it is a part of the button array.
            for(int i=0;i<model.getChoices().size();i++)
            {
                //Check each button in the array to find the source.
                if(view.getButtons().get(i).equals(e.getSource()))
                {
                    //Print to STD output the user choice.
                    System.out.println("User choice was: " + view.getButtons().get(i).getText());
                    //Add the button text to the userChoice data structure
                    model.addUserChoice(view.getButtons().get(i).getText());
                    //Print out all the users choices so far.
                    System.out.println(model.getUserChoices());

                    //Next question is only displayed if there is one.
                    if(model.hasNextQuestion())
                    {
                        model.incrementCurrentIndex();
                        getQuestion();
                    }
                    //Otherwise, show results of the data entry.
                    else
                    {
                        displayResult();
                    }

                }
            }
        }
    }
}
