package machinelearninggui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener
{
    private View view = new View();
    private Model model = new Model();
    private String dataset;

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

            this.view.getChoice1().addActionListener(this);
            this.view.getChoice2().addActionListener(this);
    }
    public void getQuestion()
    {
        //Change screen
        view.getFrame().remove(view.getMainScreen());
        view.getFrame().add(view.getQuestionPanel());
        //view.reset();

        //Setup screen.
        view.getQuestion().setText(model.getFeature());
        view.getChoice1().setText(model.getChoice1());
        view.getChoice2().setText(model.getChoice2());

    }
    public void displayResult()
    {
        view.getFrame().remove(view.getQuestionPanel());
        view.getFrame().add((view.getResultScreen()));
        view.getResultLabel().setText(model.getResult());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (view.getEntrepreneur().equals(e.getSource())) {
            System.out.println("Entrepreneur dataset was chosen.");
            dataset = "Entrepreneur";
            model.setFilename("MLData.csv");
            getQuestion();
        }
        else if(view.getSuperhero().equals(e.getSource()))
        {
            System.out.println("Superhero dataset was chosen.");
            dataset = "Superhero";
            model.setFilename("superhero.csv");
            getQuestion();
        }
        else if(view.getChoice1().equals(e.getSource()))
        {
            if(model.getLastIndex()-1 == model.getCurrentIndex())
            {
                System.out.print("Hello");
                model.setUserChoices(view.getChoice1().getText());
                //TODO Remove
                System.out.println(model.userChoices);
                displayResult();
            }
            else
            {
                model.setUserChoices(view.getChoice1().getText());
                //TODO Remove
                System.out.println(model.userChoices);
                model.incrementCurrentIndex();
                getQuestion();
            }

        }
        else if(view.getChoice2().equals(e.getSource()))
        {
            if(model.getLastIndex()-1 == model.getCurrentIndex())
            {
                System.out.print("Hello");
                model.setUserChoices(view.getChoice2().getText());
                //TODO Remove
                System.out.println(model.userChoices);
                displayResult();
            }
            else
            {
                model.setUserChoices(view.getChoice2().getText());
                //TODO Remove
                System.out.println(model.userChoices);
                model.incrementCurrentIndex();
                getQuestion();
            }
        }

    }
}
