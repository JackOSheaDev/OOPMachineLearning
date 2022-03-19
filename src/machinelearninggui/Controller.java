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
    }
    public void startQuestions()
    {
        //Change screen
        view.getFrame().remove(view.getMainScreen());
        view.getFrame().add(view.getQuestionPanel());
        view.reset();

        //Setup screen.
        view.getQuestion().setText("Hello");
        view.getChoice1().setText("A");
        view.getChoice2().setText("B");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (view.getEntrepreneur().equals(e.getSource())) {
            System.out.println("Entrepreneur dataset was chosen.");
            dataset = "Entrepreneur";
            model.setFilename("MLData.csv");
            startQuestions();
        }
        else if(view.getSuperhero().equals(e.getSource()))
        {
            System.out.println("Superhero dataset was chosen.");
            dataset = "Superhero";
            model.setFilename("superhero.csv");
            startQuestions();
        }

    }
}
