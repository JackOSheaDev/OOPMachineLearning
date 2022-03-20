package machinelearninggui;

/**
 * This is a class that is used to run the main GUI. It uses an MVC design pattern to ensure the logic is seperated
 * from te design of the application.
 *
 * @author Jack O'Shea
 * @version 1.0
 * @since 20/03/2022
 *
 */
public class Main
{
    /**
     * The display/GUI of the application which is modified and controlled by the controller.
     */
    static View display = new View();
    /**
     * The model/data of the application which is modified and controlled by the controller.
     */
    static Model data = new Model();


    /**
     * Main method which initialises the GUI.
     * @param args Default arguments to static void main.
     */
    public static void main(String[] args)
    {
        //The controller is initialised to control both the view and the model.
        new Controller(display,data);
    }
}
